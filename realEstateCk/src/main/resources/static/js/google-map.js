//var google;
//
//function init() {
//    // Tọa độ mặc định của bản đồ
//    var myLatlng = new google.maps.LatLng(10.731940, 106.699200);
//
//    var mapOptions = {
//        zoom: 10,
//        center: myLatlng,
//        scrollwheel: false,
//        styles: [
//            {
//                "featureType": "administrative.country",
//                "elementType": "geometry",
//                "stylers": [
//                    { "visibility": "simplified" },
//                    { "hue": "#ff0000" }
//                ]
//            }
//        ]
//    };
//
//    // Lấy phần tử HTML chứa bản đồ
//    var mapElement = document.getElementById('map');
//
//    // Tạo bản đồ
//    var map = new google.maps.Map(mapElement, mapOptions);
//
//    // Danh sách địa chỉ muốn lấy vị trí
//    var addresses = ['New York'];
//
//    // Thêm marker cho từng địa chỉ
//    for (var x = 0; x < addresses.length; x++) {
//        (function(address) {
//            $.getJSON('https://maps.googleapis.com/maps/api/geocode/json?address=' + address + '&key=YOUR_API_KEY', null, function(data) {
//                if (data.status === "OK") {
//                    var p = data.results[0].geometry.location;
//                    var latlng = new google.maps.LatLng(p.lat, p.lng);
//                    new google.maps.Marker({
//                        position: latlng,
//                        map: map,
//                        icon: 'images/loc.png'
//                    });
//                } else {
//                    console.error("Geocoding error: " + data.status);
//                }
//            });
//        })(addresses[x]);
//    }
//}
//
//// Đảm bảo chạy khi tải trang
//google.maps.event.addDomListener(window, 'load', init);

document.addEventListener("DOMContentLoaded", function () {
    // Tạo bản đồ với tâm tại tọa độ bạn cung cấp
    var map = L.map('map').setView([10.731940, 106.699200], 16);

    // Thêm lớp bản đồ từ OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    // Thêm marker vào vị trí bạn cung cấp
    L.marker([10.731940, 106.699200]).addTo(map)
        .bindPopup('Đây là vị trí bạn chọn!')
        .openPopup();
});