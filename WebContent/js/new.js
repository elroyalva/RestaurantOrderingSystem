// var restoData ;
// var abc = [];
// // console.log(restoData.menu.categories);
// for(dish in restoData.menu){
// // console.log(dish);
//   abc.push({"title": restoData.menu[dish].name,
//             "veg" : restoData.menu[dish].veg,
//             "text": restoData.menu[dish].description,
//             "category" : restoData.menu[dish].category,
//             "picture" : restoData.menu[dish].image,
//             "price" : restoData.menu[dish].price,
//             "glutenfree" : restoData.menu[dish].glutenfree
//           });
  
// }
//     // console.log(JSON.stringify(abc));

// var order = [];
// var myData = new WinJS.Binding.List(abc);
// var orderData = new WinJS.Binding.List(order);

// // [{
// //             "title": "Tap a dish to add to your order",
// //             "veg" : restoData.menu[dish].veg,
// //             "text": "",
// //             "category" : restoData.menu[dish].category,
// //             "picture" : "",
// //             "price" : restoData.menu[dish].price,
// //             "glutenfree" : restoData.menu[dish].glutenfree
// //           }];

// var grouped = myData.createGrouped(function (item) {
//     return item.category;
// }, function (item) {
//     return {
//         title : item.category
//     };
// }, function (left, right) {
//     return left.charCodeAt(0) - right.charCodeAt(0);
// });
//     console.log(JSON.stringify(grouped));


// WinJS.Namespace.define("Sample.ListView", {
//     data: grouped
// });

// WinJS.Namespace.define("Order.ListView", {
//     data: orderData
//     // data : grouped
// });

// WinJS.UI.processAll().done(function () {
//     var splitView = document.querySelector(".splitView").winControl;
//     new WinJS.UI._WinKeyboard(splitView.paneElement); // Temporary workaround: Draw keyboard focus visuals on NavBarCommands
// });

// var x = document.getElementsByClassName("win-splitview-content");
// var i;
// for (i = 0; i < x.length; i++) {
// 	x[i].style.backgroundImage = 'url('+ restoData.image + ')';
// }
// var x =document.getElementById("rest_name");
// // console.log(x);
// x.innerHTML='';
// x.appendChild(document.createTextNode(restoData.name));

// var addr =document.getElementsByClassName("win-contentdialog-content");
// // for (i = 0; i < x.length; i++) {
//   addr[0].appendChild(document.createTextNode(restoData.address));
// // }
// // addr.innerHTML='';
// // addr.appendChild(document.createTextNode(restoData.address));

// var dishlist = document.getElementById("listview").winControl;
// // alert(dishlist);
// dishlist.oniteminvoked = function (event) {
//     var index = event.detail.itemIndex;
//     // alert(index);
//     var item = grouped.getAt(index);
//     // alert(item.title);
//     orderData.push(item);
//     // console.log(JSON.stringify(orderData));
//     // myData.push(item);
// }

// var showButton = document.querySelector(".addrLink");
//     showButton.addEventListener("click", function () {
//         var contentDialog = document.querySelector("#addressDialog").winControl;
//         contentDialog.show();
//     });

// function showAddress(){
//   alert(restoData.address);
// }

// function placeOrder(){
//    // alert('{restID:'+restoData.id+', orders: '+orderData.slice(0)+'}');
//   var placeOrderURL = "/ROSService/placeOrder";
//   var xhr = new XMLHttpRequest();
//   xhr.open("POST", placeOrderURL);
//   xhr.setRequestHeader('Content-Type', 'application/json');
//   xhr.onreadystatechange = function () {
//      if (xhr.readyState == 4 && xhr.status == 200) {
//          callback(xhr.responseText);
//          alert(xhr.responseText);
//      }
//   }
//   xhr.send(JSON.stringify('{restID:'+restoData.id+', orders: '+orderData.slice(0)+'}'));
// }

// function resetOrder(){
//   orderData.splice(0, orderData.length);
// }

var restoData ;
var tableNo;
var abc = [];
// console.log(restoData.menu.categories);
for(dish in restoData.menu){
// console.log(dish);
  abc.push({"title": restoData.menu[dish].name,
            "veg" : restoData.menu[dish].veg,
            "text": restoData.menu[dish].description,
            "category" : restoData.menu[dish].category,
            "picture" : restoData.menu[dish].image,
            "price" : restoData.menu[dish].price,
            "glutenfree" : restoData.menu[dish].glutenfree
          });
  console.log('veg : ' + restoData.menu[dish].veg);
  console.log('glutenfree : ' + restoData.menu[dish].glutenfree);
  
}
var order = [];
var myData = new WinJS.Binding.List(abc);
var orderData = new WinJS.Binding.List(order);

// [{
//             "title": "Tap a dish to add to your order",
//             "veg" : restoData.menu[dish].veg,
//             "text": "",
//             "category" : restoData.menu[dish].category,
//             "picture" : "",
//             "price" : restoData.menu[dish].price,
//             "glutenfree" : restoData.menu[dish].glutenfree
//           }];

var grouped = myData.createGrouped(function (item) {
    return item.category;
}, function (item) {
    return {
        title : item.category
    };
}, function (left, right) {
    return left.charCodeAt(0) - right.charCodeAt(0);
});

WinJS.Namespace.define("Sample.ListView", {
    data: grouped
});

WinJS.Namespace.define("Order.ListView", {
    data: orderData
    // data : grouped
});

WinJS.UI.processAll().done(function () {
    var splitView = document.querySelector(".splitView").winControl;
    new WinJS.UI._WinKeyboard(splitView.paneElement); // Temporary workaround: Draw keyboard focus visuals on NavBarCommands
});

var x = document.getElementsByClassName("win-splitview-content");
var i;
for (i = 0; i < x.length; i++) {
  x[i].style.backgroundImage = 'url('+ restoData.image + ')';
}
var x =document.getElementById("rest_name");
// console.log(x);
x.innerHTML='';
x.appendChild(document.createTextNode(restoData.name));

var addr =document.getElementsByClassName("win-contentdialog-content");
// for (i = 0; i < x.length; i++) {
  addr[0].appendChild(document.createTextNode(restoData.address));
// }
// addr.innerHTML='';
// addr.appendChild(document.createTextNode(restoData.address));

var dishlist = document.getElementById("listview").winControl;
// alert(dishlist);
dishlist.oniteminvoked = function (event) {
    var index = event.detail.itemIndex;
    // alert(index);
    var item = grouped.getAt(index);
    // alert(item.title);
    orderData.push(item);
    // console.log(JSON.stringify(orderData));
    // myData.push(item);
}

var showButton = document.querySelector(".addrLink");
    showButton.addEventListener("click", function () {
        var contentDialog = document.querySelector("#addressDialog").winControl;
        contentDialog.show();
    });

function showAddress(){
  alert(restoData.address);
}

function placeOrder(){
   // alert('{restID:'+restoData.id+', orders: '+orderData.slice(0)+'}');
  var placeOrderURL = "/RestaurantOrderingSystem/ros/placeOrder";
  var xhr = new XMLHttpRequest();
  xhr.open("POST", placeOrderURL);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.onreadystatechange = function () {
     if (xhr.readyState == 4 && xhr.status == 200) {
         callback(xhr.responseText);
         alert(xhr.responseText);
     }
  }
//  alert(orderData.slice(0));
//  alert(orderData.slice(0)[0].title);
  var orderArray = JSON.stringify(orderData.slice(0));
//  alert(orderArray);
  xhr.send(JSON.stringify('{restID:'+restoData.id+',tableno:'+ tableNo +',' + 'orders: '+orderArray+'}'));
}

function resetOrder(){
  orderData.splice(0, orderData.length);
}

var myConverter = WinJS.Binding.converter(function (val) {
    return val ? "initial" : "none";
});