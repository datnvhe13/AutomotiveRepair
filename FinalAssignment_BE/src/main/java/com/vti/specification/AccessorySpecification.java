package com.vti.specification;

import com.vti.entity.Accessory;
import com.vti.form.accessory.AccessoryFilterForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccessorySpecification {
    // search by carLicense_plate, accessoryName, carRepair_date
    private static final String CARLICENSE_PLATE = "carLicense_plate";
    private static final String CARREPAIR_DATE = "carRepair_date";
    private static final String ACCESSORYNAME = "accessoryName";

    public static Specification<Accessory> buildWhere(AccessoryFilterForm filterForm){
        if(filterForm == null){
            return null;
        }
        Specification<Accessory> where_carLicense_plate =
                 new SpecificationIml(CARLICENSE_PLATE, filterForm.getSearch());
        Specification<Accessory> where_carRepair_date =
                new SpecificationIml(CARREPAIR_DATE, filterForm.getCarRepairDate());
        Specification<Accessory> where_accessoryName =
                new SpecificationIml(ACCESSORYNAME, filterForm.getSearch());
        return Specification.where(where_carLicense_plate.or(where_accessoryName).and(where_carRepair_date));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class SpecificationIml implements Specification<Accessory> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Accessory> root,
                                     CriteriaQuery<?> query,
                                     CriteriaBuilder criteriaBuilder) {

            if(value == null){
                return null;
            }
            switch (key){
                case CARLICENSE_PLATE:
                    return criteriaBuilder.like(root.get("car").get("id").get("licensePlate"),
                            "%" + value + "%");
                case CARREPAIR_DATE:
                    return criteriaBuilder.equal(root.get("car").get("id").get("repairDate"), "%" + value + "%");
                case ACCESSORYNAME:
                    return criteriaBuilder.like(root.get("name"), "%" + value +"%");
            }
            return null;
        }
    }
}
