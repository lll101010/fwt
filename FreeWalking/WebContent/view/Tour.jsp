<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
		h1 {
			font-family: 'Yanone Kaffeesatz', sans-serif;
			text-align: center;
			font-size: 77px;
			text-shadow: 0 0px 30px rgba(0, 0, 0, 0.2);
		}
		h2 {
			font-family: 'Yanone Kaffeesatz', sans-serif;
			font-size:30px;
			text-shadow: 0 0px 20px rgba(0, 0, 0, 0.3);
			color:#fff;
		}
		.monthly {
			box-shadow: 0 13px 40px rgba(0, 0, 0, 0.5);
			font-size: 0.8em;
		}

		input[type="text"] {
			padding: 15px;
			border-radius: 2px;
			font-size: 16px;
			outline: none;
			border: 2px solid rgba(255, 255, 255, 0.5);
			background: rgba(63, 78, 100, 0.27);
			color: #fff;
			width: 250px;
			box-sizing: border-box;
			font-family: "Trebuchet MS", Helvetica, sans-serif;
		}
		input[type="text"]:hover {
			border: 2px solid rgba(255, 255, 255, 0.7);
		}
		input[type="text"]:focus {
			border: 2px solid rgba(255, 255, 255, 1);
			background:#eee;
			color:#222;
		}

		.button {
			display: inline-block;
			padding: 15px 25px;
			margin: 25px 0 75px 0;
			border-radius: 3px;
			color: #fff;
			background: #000;
			letter-spacing: .4em;
			text-decoration: none;
			font-size: 13px;
		}
		.button:hover {
			background: #3b587a;
		}
		.desc {
			max-width: 250px;
			text-align: left;
			font-size:14px;
			padding-top:30px;
			line-height: 1.4em;
		}
		.resize {
			background: #222;
			display: inline-block;
			padding: 6px 15px;
			border-radius: 22px;
			font-size: 13px;
		}
		@media (max-height: 700px) {
			.sticky {
				position: relative;
			}
		}
		@media (max-width: 600px) {
			.resize {
				display: none;
			}
		}
	</style>
<link href="${ctx}/resource/css/fwt.css?ver=1" rel="stylesheet">
<link href="${ctx }/resource/bootstrap/css/bootstrap.css?ver=1" rel="stylesheet">
<script type="text/javascript">
function initialize() {

	/*
		http://openapi.map.naver.com/api/geocode.php?key=f32441ebcd3cc9de474f8081df1e54e3&encoding=euc-kr&coord=LatLng&query=서울특별시 강남구 강남대로 456
        위의 링크에서 뒤에 주소를 적으면 x,y 값을 구할수 있습니다.
	*/
	var Y_point			= 37.527371;	 	// Y 좌표
	var X_point			= 126.932767;		// X 좌표

	var zoomLevel		= 16;						// 지도의 확대 레벨 : 숫자가 클수록 확대정도가 큼

	var markerTitle		= "여의나루 역";				// 현재 위치 마커에 마우스를 오버을때 나타나는 정보
	var markerMaxWidth	= 300;						// 마커를 클릭했을때 나타나는 말풍선의 최대 크기

	// 말풍선 내용
	var contentString	= '<div>' +
	'<h2>위즈소프트</h2>'+
	'<p>위즈소프트는 WEB Agency & SI 분야에서 10년 이상의 풍부한 경험을 보유한<br />' +
    '전문 인력으로 구성된 E-Business 전문 기업입니다.</p>' +
	//'<a href="http://www.daegu.go.kr" target="_blank">http://www.daegu.go.kr</a>'+ //링크도 넣을 수 있음
	'</div>';

	var myLatlng = new google.maps.LatLng(Y_point, X_point);
	var mapOptions = {
						zoom: zoomLevel,
						center: myLatlng,
						mapTypeId: google.maps.MapTypeId.ROADMAP
	}
	var map = new google.maps.Map(document.getElementById('map'), mapOptions);

	var marker = new google.maps.Marker({
											position: myLatlng,
											map: map,
											title: markerTitle
	});


	google.maps.event.addListener(marker, 'click', function() {
		infowindow.open(map, marker);
	});
}

</script>
</head>
<body onload="initialize()">
<div id="contents">
	<div id="menu">
	</div>
	<div id="area" style="background-image: url('${ctx}/resource/img/place.jpg');
							 background-repeat: no-repeat;
							 background-size: 100% 100%;" >
			<a href="#"><img class="fwt-button" src="${ctx }/resource/img/left.png" style="height: 30px; width: 30px; margin: 370px 0px 0px 20px;"></a>
			<a href="#"><img class="fwt-button" src="${ctx }/resource/img/right.png" style="height: 30px; width: 30px; margin: 370px 10px 10px 10px;"></a>							 
	</div>
	<div id="map"></div>
	
	<div id="weather" style="background-image: url('${ctx}/resource/img/cloud.jpg');
							 background-repeat: no-repeat;
							 background-size: 100% 100%;">
	</div>
	<div id="caleander">
		<div class="monthly" id="mycalendar"></div>
	</div>
	<div id="caleander-day"></div>
</div>


<%-- <script src="${ctx}/resource/bootstrap/js/bootstrap.js"></script> --%>
<script src="${ctx}/resource/js/jquery.js"></script>
<script src="${ctx}/resource/js/monthly.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFkFnfcDR1GE6CJGhiKPWU4jyqf8IZagY"></script>
<script type="text/javascript">
	$(window).load( function() {

		$('#mycalendar').monthly({
			mode: 'event',
			//jsonUrl: 'events.json',
			//dataType: 'json'
			xmlUrl: 'events.xml'
		});

		$('#mycalendar2').monthly({
			mode: 'picker',
			target: '#mytarget',
			setWidth: '250px',
			startHidden: true,
			showTrigger: '#mytarget',
			stylePast: true,
			disablePast: true
		});

	switch(window.location.protocol) {
	case 'http:':
	case 'https:':
	// running on a server, should be good.
	break;
	case 'file:':
	alert('Just a heads-up, events will not work when run locally.');
	}

	});
</script>
</body>
</html>