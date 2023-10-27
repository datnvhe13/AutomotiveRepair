package com.vti.specification;

import com.vti.entity.Car;
import com.vti.form.car.CarFilterForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CarSpecification {
    //search by license_plate, customer_name, car_maker, repair_date, minYear
    private static final String LICENSE_PLATE = "license_plate";
    private static final String CUSTOMER_NAME = "customer_name";
    private static final String CAR_MAKER = "car_maker";
    private static final String REPAIR_DATE = "repair_date";
    private static final String MIN_Year = "minYear";

    public static Specification<Car> buildWhere(CarFilterForm form){
        if(form == null){
            return null;
        }
        Specification<Car> whereCar_license_plate =
                                new SpecificationIml(LICENSE_PLATE, form.getSearch());
        Specification<Car> whereCar_customer_name =
                                new SpecificationIml(CUSTOMER_NAME, form.getSearch());
        Specification<Car> whereCar_car_maker =
                                new SpecificationIml(CAR_MAKER, form.getSearch());
        Specification<Car> whereCar_repair_date =
                                new SpecificationIml(REPAIR_DATE, form.getRepairDate());
        Specification<Car> whereCar_minYear =
                                new SpecificationIml(MIN_Year, form.getMinYear());

        return Specification.where(
                whereCar_license_plate.or(
                        whereCar_customer_name).or(whereCar_car_maker
                .and(whereCar_repair_date)
                .and(whereCar_minYear)));
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class SpecificationIml implements Specification<Car> {

        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if(value == null){
                return null;
            }
            switch (key){
                case LICENSE_PLATE:
                    return criteriaBuilder.like(root.get("id").get("licensePlate"), "%" + value + "%");
                case CUSTOMER_NAME:
                    return criteriaBuilder.like(root.get("customerName"), "%" + value + "%");
                case CAR_MAKER:
                    return criteriaBuilder.like(root.get("carMaker"), "%" + value + "%");
                case REPAIR_DATE:
                    return criteriaBuilder.equal(root.get("id").get("repairDate"), "%" + value + "%");
                case MIN_Year:
                    return criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.function("YEAR", Integer.class,
                            root.get("id").get("repairDate")), (Integer) value);
            }
                return null;
        }
    }
}






























