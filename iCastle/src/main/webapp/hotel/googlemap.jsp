<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0">
<title>google map</title>
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
       html, body {  
         height: 100%; 
         margin: 0; 
         padding: 0; 
       } 
</style>

</head>
<body>
	<div >a map</div>
	<div id="map"></div>

</body>
	
<script src="../js/jquery.min.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCn7jC3DDQXAbDR9-IDsCnNL79Hsuz-55k&callback=initMap"
  type="text/javascript"></script>
<script>

	function initMap(){
		var map = new google.maps.Map(document.getElementById("map"), {
			center: {
	                   "lat" : 25.042787,
	                   "lng" : 121.509309
	                },
			zoom:20
		});
		var geocoder  = new google.maps.Geocoder();
		geocodeAddress(geocoder, map);
	} 
	
	function geocodeAddress(geocoder, map){
		//將地址轉換成坐標
// 		var address = [" 台北市中正區秀山街4號", "  台北市中山區中山北路四段1號", " 台北市信義區松高路18號"
// 			, "台北市士林區福德路48巷8號", "台北市士林區中山北路七段127號", "台北市中山區一江街3號", "高雄市苓雅區自強三路1號"];
		var address = ["  台北市中山區中山北路四段1號", " 台北市中正區秀山街4號", "台北市信義區松高路18號"
			, "台北市士林區福德路48巷8號", "台北市士林區中山北路七段127號", "台北市中山區一江街3號", "高雄市苓雅區自強三路1號"];

		console.log(address[0]);
		//設定center
		geocoder.geocode( {"address" : address[0]}, function(results, status){
			if (status == google.maps.GeocoderStatus.OK) {
				console.log("成功轉換" + results[0].geometry.location);
				//設定新的center
				map.setCenter(results[0].geometry.location);
			} else 
				console.log("無法轉換..."+ status);
		})

		//設定marker
		for (var i=0 ; i<address.length ; i++){
			geocoder.geocode( {"address" : address[i]}, function(results, status){
				if (status == google.maps.GeocoderStatus.OK) {
					console.log("成功轉換" + results[0].geometry.location);
					//設定新的center
					if (i==0)
						map.setCenter(results[0].geometry.location);
					//設定marker
					var marker = new google.maps.Marker({
						map : map,
						position : results[0].geometry.location
					});
				} else 
					console.log("無法轉換..."+ status);
			})
		}
	}

</script>
</html>