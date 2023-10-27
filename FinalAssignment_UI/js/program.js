// ==============================Start processing load form ======================================
$(function () {
  $(".Banner").load("banner.html");
  $(".MenuLeft").load("menuLeft.html");
  $(".Body").load("body.html");
  $(".Footer").load("footer.html");
});

function addNewCar() {
  $(".Body").load("addNewCarForm.html");
}
function accessoryDetail() {
  getAllAccessories();
  $(".Body").load("accessoryDetail.html");
  // var x = $("#licensePlate").val();
  // console.log(x);
}

// when click on "CarManagement"
function viewListCars() {
  getAllCars();
  $(".Body").load("carManagement.html");
}
// ==============================End processing load form ======================================

// ==============================Start processing Create new car======================================
function saveNewCar() {
  var licensePlate = document.getElementById("licensePlate").value;
  var repairDate = document.getElementById("repairDate").value;
  var customerName = document.getElementById("customerName").value;
  var catalogs = document.getElementById("catalog").value;
  var carMaker = document.getElementById("carMaker").value;

  if (
    licensePlate == null ||
    repairDate == null ||
    customerName == null ||
    catalogs == null ||
    carMaker == null
  ) {
    alert("You must fill enough information !");
    return;
  } else {
    var new_Car = {
      idLicensePlate: licensePlate,
      idRepairDate: repairDate,
      customerName: customerName,
      catalogs: catalogs,
      carMaker: carMaker,
    };
    console.log(new_Car);
    // alert(new_Car);
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/api/v1/cars",
      data: JSON.stringify(new_Car),
      contentType: "application/json", // type of body (json, xml, text)
      //dataType: "dataType",
      success: function (response) {
        alert("Create new car successfully !");
        resetAddNewCarForm();
      },
      error(jqXHR, textStatus, errorThrown) {
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      },
    });
  }
}

function resetAddNewCarForm() {
  document.getElementById("licensePlate").value = "";
  document.getElementById("repairDate").value = "";
  document.getElementById("customerName").value = "";
  document.getElementById("catalog").value = "";
  document.getElementById("carMaker").value = "";
}

// ==============================The end processing Create new car======================================

// ==============================Start processing Modal======================================

function deleteCarByIdLicensePlate(licensePlate) {
  console.log("delete car by ID : " + licensePlate);

  var confirmDelete = confirm("Do you want to delete this car ?");

  if (confirmDelete) {
    $.ajax({
      type: "DELETE",
      url: `http://localhost:8080/api/v1/cars/${licensePlate}`,
      //dataType: "JSON",
      contentType: "application/json",
      success: function (response) {
        //console.log(response);
        alert("Delete " + licensePlate + " successfully !");
        //loadCars(cars);
        getAllCars();
        //   location.reload();
      },
    });
  }
}

function openEditModal(idCar) {
  // console.log(idCar);
  openModal(idCar);
}

function openModal(idCar) {
  var carUpdate = cars.find((car) => car.idLicensePlate == idCar);
console.log(carUpdate.idRepairDate);
  //set value for modal update Car
  $("#licensePlate").val(carUpdate.idLicensePlate);
  $("#repairDate").val(carUpdate.idRepairDate);
  $("#customerName").val(carUpdate.customerName);
  $("#catalog").val(carUpdate.catalogs);
  $("#carMaker").val(carUpdate.carMaker);

  $("#myModal").modal("show");
}

function editCar() {
  //get CarUpdate's information from update modal
  var licensePlate = document.getElementById("licensePlate").value;
  var repairDate = document.getElementById("repairDate").value;
  var customerName = document.getElementById("customerName").value;
  var catalogs = document.getElementById("catalog").value;
  var carMaker = document.getElementById("carMaker").value;

  //create update_car
  var update_Car = {
    idLicensePlate: licensePlate,
    idRepairDate: repairDate,
    customerName: customerName,
    catalogs: catalogs,
    carMaker: carMaker,
  };
  console.log(update_Car);
  console.log(JSON.stringify(update_Car));

  $.ajax({
    type: "PUT",
    url: `http://localhost:8080/api/v1/cars`,
    data: JSON.stringify(update_Car),
    //dataType: "JSON",
    contentType: "application/json;charset=UTF-8",
    success: function (response) {
      alert("Update successfully !");
      hideModal();
      location.reload();
    },
  });
}

function hideModal() {
  $("#myModal").modal("hide");
}

function openEditAccessoryModal(idAccessory) {
  openAccessoryModal(idAccessory);
}

function openAccessoryModal(idAccessory) {

  var accessory_update = accessories.find((accessory)=> accessory.id ==  idAccessory);
  console.log(accessory_update);

  console.log(accessory_update.carIdRepairDate);

  $("#modal_ID").val(idAccessory);
  $("#modal_licensePlate").val(accessory_update.carIdLicensePlate);
  $("#modal_repairDate").val(accessory_update.carIdRepairDate);
  $("#modal_Name").val(accessory_update.name);
  $("#modal_Price").val(accessory_update.price);
  $("#modal_statusDamaged").val(accessory_update.statusDamaged);
  $("#modal_repairStatus").val(accessory_update.repairStatus);


  $("#myAccessoryModal").modal("show");
}

function hideAccessoryModal() {
  $("#myAccessoryModal").modal("hide");
}

// ==============================End processing Modal======================================

// ==============================Start processing Get all CARS ======================================

var cars = [];

function getAllCars() {
  $.ajax({
    url: "http://localhost:8080/api/v1/cars",
    type: "GET",
    contentType: "application/json; charset=utf-8",
    success: function (data, status, xhr) {
      cars = data.content;
      console.log("CarSize : " + cars.length);
      loadCars(cars);
    },
    error: function (xhr, status) {
      console.log("Error !");
    },
  });
}

function loadCars(cars) {
  $("#table_Car tbody").empty();

  for (var index = 0; index < cars.length; index++) {
    $("#table_Car tbody").append(`<tr>
        <td>${index + 1}</td>
        <td>${cars[index].idLicensePlate}</td>
        <td>${cars[index].idRepairDate}</td>
        <td>${cars[index].customerName}</td>
        <td>${cars[index].catalogs}</td>
        <td>${cars[index].carMaker}</td>
        <td>
          <button type="button" class="btn btn-info add-new" onclick="openEditModal('${
            cars[index].idLicensePlate
          }')">Edit</button>
        </td>
        <td>
          <button type="button" class="btn btn-info delete" onclick="deleteCarByIdLicensePlate('${
            cars[index].idLicensePlate
          }')">Delete</button>
        </td>
      </tr>`);
  }
}

// ==============================End processing Get all CARS ======================================

// ==============================Start processing Get all Accessory ======================================

var accessories = [];

function getAllAccessories() {
  $.ajax({
    url: "http://localhost:8080/api/v1/accessories",
    type: "GET",
    contentType: "application/json; charset=utf-8",
    success: function (data, status, xhr) {
      accessories = data.content;
      console.log("accessories : " + accessories.length);
      loadAccessories(accessories);
    },
    error: function (xhr, status) {
      console.log("Error !");
    },
  });
}

function loadAccessories(accessories) {
  $("#table_accessory tbody").empty();

  for (var index = 0; index < accessories.length; index++) {
    $("#table_accessory tbody").append(`<tr>
        <td>${(index + 1)}</td>
        <td>${accessories[index].carIdLicensePlate}</td>
        <td>${accessories[index].carIdRepairDate}</td>
        <td>${accessories[index].name}</td>
        <td>${accessories[index].price}</td>
        <td>${accessories[index].statusDamaged}</td>
        <td>${accessories[index].repairStatus}</td>
        <td>
          <button type="button" class="btn btn-info add-new" onclick="openEditAccessoryModal(${accessories[index].id})">Edit</button>
        </td>
        <td>
          <button type="button" class="btn btn-info delete" onclick="deleteAccessoryById(${accessories[index].id})">Delete</button>
        </td>
      </tr>`);
  }
}

// ==============================End processing Get all CARS ======================================

// ==============================Start processing Create new accessory======================================
function saveNewAccessory() {

  var licensePlate = document.getElementById("licensePlate").value;
  var repairDate = document.getElementById("repairDate").value;
  var Name = document.getElementById("Name").value;
  var Price = document.getElementById("Price").value;
  var statusDamaged = document.getElementById("statusDamaged").value;
  var repairStatus = document.getElementById("repairStatus").value;

  var new_Accessory = {
    carIdLicensePlate: licensePlate,
    carIdRepairDate: repairDate,
    name: Name,
    price: Price,
    statusDamaged: statusDamaged,
    repairStatus: repairStatus,
  };
  console.log(new_Accessory);

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/api/v1/accessories",
    data: JSON.stringify(new_Accessory),
    contentType: "application/json", // type of body (json, xml, text)
    //dataType: "dataType",
    success: function (response) {
      alert("Create new accessory successfully !");
      resetAddNewAssessoryForm();
      getAllAccessories();
    },
    error(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    },
  });
}
function resetAddNewAssessoryForm() {
  document.getElementById("licensePlate").value = "";
  document.getElementById("repairDate").value = "";
  document.getElementById("Name").value = "";
  document.getElementById("Price").value = "";
  document.getElementById("statusDamaged").value = "";
  document.getElementById("repairStatus").value = "";
}

// ==============================The end processing Create new accessory======================================

// ==============================Start processing Delete accessory by Id======================================

function deleteAccessoryById(id) {
  var confirmDelete = confirm("Do you want delete this accessory ?");

  if (confirmDelete) {
    $.ajax({
      type: "DELETE",
      url: `http://localhost:8080/api/v1/accessories/${id}`,
      //dataType: "JSON",
      contentType: "application/json",
      success: function (response) {
        //console.log(response);
        alert("Delete successfully !");
        //loadCars(cars);
        getAllAccessories();
        //   location.reload();
      },
    });
  }
}

//============================================Start processing update Accessory by Id 

function editAccessory(){
     //get CarUpdate's information from update modal 
    var Id = document.getElementById("modal_ID").value;
  var licensePlate = document.getElementById("modal_licensePlate").value;
  var repairDate = document.getElementById("modal_repairDate").value;
  var accessoryName = document.getElementById("modal_Name").value;
  var price = document.getElementById("modal_Price").value;
  var statusDamaged = document.getElementById("modal_statusDamaged").value;
  var repairStatus = document.getElementById("modal_repairStatus").value;

  //create update_car
  var update_Accessory = {
    carIdLicensePlate: licensePlate,
    carIdRepairDate: repairDate,
    name: accessoryName,
    price: price,
    statusDamaged: statusDamaged,
    repairStatus: repairStatus,
  };
  console.log(update_Accessory);
  console.log(Id);
  console.log(JSON.stringify(update_Accessory));

  $.ajax({
    type: "PUT",
    url: `http://localhost:8080/api/v1/accessories/${Id}`,
    data: JSON.stringify(update_Accessory),
    //dataType: "JSON",
    contentType: "application/json;charset=UTF-8",
    success: function (response) {
      alert("Update successfully !");
      hideUpdateAccessoryModal();
      location.reload();
    },
  });

}

function hideUpdateAccessoryModal(){

}