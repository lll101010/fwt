<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="./header.jspf"%>
<meta name="google-signin-client_id"
	content="1006094630241-2u32bu1k1komv4nepbmbbvrajogpvvj2.apps.googleusercontent.com"></meta>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Owl-Carousel-CSS -->
<link rel="stylesheet" href="${ctx }/resource/css/owl.carousel.css"
	type="text/css" media="all">

<!-- //For-Mobile-Apps -->



<body onload="startTime()">
	<!-- banner -->
	<div id="home" class="w3ls-banner" style="background: url('/img/${place.name}.jpg')no-repeat 0px 0px; background-size: 100% 100%">
		<!-- header -->
		<div class="header">
			<div class="container">
				<div class="logo" style="display: flex">
					<h1>
						<a href="${ctx }/placelist.do" style=" text-shadow: 0 0 2px #f00;">Free Walking Tour</a>
					</h1>
					<img src="" id="profileImg" style="max-height: 45px" class="img-circle">
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- //header -->



		<!-- 로그인 전 네비 -->
		<nav class="cd-stretchy-nav edit-content">
			<a class="cd-nav-trigger" href="#0"> Menu <span
				aria-hidden="true"></span>
			</a>
			<ul>
				<li><a href="${ctx }/placelist.do"><span>Home</span></a></li>
				<li><a href="#loginModal" data-toggle="modal"
					style="content: '\f012';" id="loginNav"><span id="loginSpan">Login</span></a></li>
				<li><a href="#portfolio" class="scroll"><span>Gallery</span></a></li>
				<li><a href="#" onclick="postList()" class="scroll"><span>Board</span></a></li>
				<li><a href="#messageModal" onclick="findMessage()" data-toggle="modal" class="loginS" style="display: none;"><span>Message</span></a></li>
				<li><a href="#" onclick="myPage()" class="loginS" style="display: none;"><span>MyTour</span></a></li>
			</ul>
			<span aria-hidden="true" class="stretchy-nav-bg"></span>
		</nav>

		<!-- message modal -->
		<div class="modal bnr-modal fade" id="messageModal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document" style="width: 90%">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body modal-spa">
						<!-- <img src="images/bg2.jpg" class="img-responsive" alt="" /> -->
						<h4 style="text-align: center;">Message Box</h4>
						<br>
						<div style="display: inline-flex;width: 100%;color: coral;font-weight: bold;">
							<div style=" text-align: center; width: 20%; "><span>보낸사람  </span></div>
							<div style=" text-align: center; width: 20%; "><span>보낸시간  </span></div>
							<div style=" text-align: center; width: 60%; "><span style="text-align: center;"> 내용</span></div>
						</div>
						<br><br>
						<div id="messageContents" style="width: 100%;">
							<div style=" text-align: center; width: 20%; "><span>lll101010s2@gmail.com  </span></div>
							<div style=" text-align: center; width: 20%; "><span>2017-06-14 11:00  </span></div>
							<div style=" text-align: center; width: 60%; "><span style="text-align: center;"> dasdsadsad</span>
								<a href="#">
									<button type="button" class="close" aria-label="Close" style="color: coral;">
									<span aria-hidden="true">&times;</span>
									</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- banner-text -->
		<div class="banner-w3ltext">
			<div class="container">

				<!-- 날씌 -->
				<div class="weather-widget agileits w3layouts">
					<div class="place agileits w3layouts">

						<div class="city agileits-w3layouts agileits w3layouts">
							<h3>${place.city }</h3>
							<h2>${place.nameKor }</h2>
						</div>

						<a href="#myModal" class="wthree-btn" data-toggle="modal">Location</a>
						<a href="#guideApplyModal" id="gA" class="wthree-btn"
							data-toggle="modal" style="display: none">Guide Apply</a>

						<div class="dmy agileits w3-agile w3layouts">
							<script type="text/javascript">
								var mydate = new Date()
								var year = mydate.getYear()
								if (year < 1000)
									year += 1900
								var day = mydate.getDay()
								var month = mydate.getMonth()
								var daym = mydate.getDate()
								if (daym < 10)
									daym = "0" + daym
								var dayarray = new Array("Sunday", "Monday",
										"Tuesday", "Wednesday", "Thursday",
										"Friday", "Saturday")
								var montharray = new Array("January",
										"February", "March", "April", "May",
										"June", "July", "August", "September",
										"October", "November", "December")
								document.write(
										"" + dayarray[day] + ", "
												+ montharray[month] + " "
												+ daym + ", " + year + "")
							</script>
						</div>
						<div id="txt"></div>

						<div class="w3temperatureaits agileits w3-agileits">
							<div class="w3temperatureaits-grid w3-agileits wthreetemp">
								<p>${temp0 }°C</p>
							</div>
							<div class="w3temperatureaits-grid w3tempimg">
								<figure class="icons agileits w3layouts">
									<canvas class="${day0 }" width="70" class="w3-agileits"
										height="70"></canvas>
								</figure>
							</div>
							<div class="w3temperatureaits-grid w3-agile wthreestats">
								<ul>
									<li class="agiletemp wthree agiletemphumidity w3-agile">${humidity }%
										Humidity</li>
									<li
										class="agiletemp agileits-w3layouts agileinfo agiletempwind">${wind }m/s
										NE</li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>

						<div id="owl-demo" class="owl-carousel agileits text-center">
							<div class="item w3threeitem w3threeitem1">
								<h4>${days1 }</h4>
								<figure class="icons agileits-w3layouts agileits w3layouts">
									<canvas class="${day1 }" width="50" height="50"></canvas>
								</figure>
								<h5>${temp1 }°C</h5>
							</div>
							<div class="item w3threeitem agileinfo w3threeitem2">
								<h4>${days2 }</h4>
								<figure class="icons wthree agileits w3layouts">
									<canvas class="${day2 }" width="50" height="50"></canvas>
								</figure>
								<h5>${temp2 }°C</h5>
							</div>
							<div class="item w3 w3threeitem w3threeitem3">
								<h4>${days3 }</h4>
								<figure class="icons agileits w3layouts">
									<canvas class="${day3 }" width="50" height="50"></canvas>
								</figure>
								<h5>${temp3 }°C</h5>
							</div>
							<div class="item w3threeitem w3threeitem4">
								<h4>${days4 }</h4>
								<figure class="icons agileits w3layouts">
									<canvas class="${day4 }" class="fog" width="50" class="w3ls"
										height="50"></canvas>
								</figure>
								<h5>${temp4 }°C</h5>
							</div>
							<div class="item w3threeitem wthree agileinfo w3threeitem5">
								<h4>${days5 }</h4>
								<figure class="icons agileits w3layouts">
									<canvas class="${day5 }" width="50" height="50"></canvas>
								</figure>
								<h5>${temp5 }°C</h5>
							</div>
							<div class="item w3threeitem wthree agileinfo w3threeitem6">
								<h4>${days6 }</h4>
								<figure class="icons agileits w3layouts">
									<canvas class="${day6 }" width="50" height="50"></canvas>
								</figure>
								<h5>${temp6 }°C</h5>
							</div>

						</div>

					</div>
				</div>




			</div>
		</div>
		<!-- //banner-text -->
	</div>
	<!-- //banner -->
	<!-- banner-bottom -->
	<div class="serach-w3agile">
		<div class="container">
			
			<div class="place-grids">

				<div class="col-md-2 col-xs-4 place-grid" style="margin-left: 20%">
					<h5>First Date</h5>
					<input class="sel2" type="date" name="firstDate" id="firstDate"
						name="firstDate">
				</div>
				<div class="col-md-2 col-xs-4 place-grid">
					<h5>Last Date</h5>
					<input class="sel2" type="date" name="lastDate" id="lastDate"
						name="lastDate">
				</div>

				<div class="col-md-2 col-xs-4 place-grid">
					<h5>People</h5>
					<select class="sel" required="" name="people" id="people">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
					</select>
				</div>
				<!-- <div class="col-md-2 col-xs-4 place-grid">
					<h5>Use Language</h5>
					<select class="sel" required="" name="language">
						<option value="">Language</option>
						<option value="Korean">Korean</option>
						<option value="English">English</option>
						<option value="Japanese">Japanese</option>
						<option value="Chinese">Chinese</option>
						<option value="German">German</option>
					</select>
				</div> -->
				<div class="col-md-2 col-xs-4 place-grid">
					<button type="button" onclick="findApply()" class="sbBtn">search</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //banner-bottom -->

	<div class="blog-agileinfo" id="ContentArea">


		<div class="clearfix"></div>
	</div>

	<form action="${ctx }/postList.do" id="postForm">
						<input type="hidden" name="postPlaceId" value="${place.id }"> 
						<input type="hidden" id="postApplyId" name="postUserId">
	</form> 


	<!-- //footer -->
	<!-- modal-about -->
	<div class="modal bnr-modal fade" id="myModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>



				<div class="modal-body modal-spa">

					<div
						class="map">
						<iframe
							src="https://www.google.com/maps/embed/v1/place?key=AIzaSyDx6PhbZtEg6VsBhod8enpuRaFK4LQY5ZU
   								 &q=${place.address }" allowfullscreen">
						</iframe>
					</div>

					<h4>${place.contents }</h4>
					<p>${place.address }</p>
				</div>
			</div>
		</div>
	</div>
	<!-- //modal-about -->
	
	
	

	<div class="modal bnr-modal fade" id="guideApplyModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div id="loginF" class="modal-body modal-spa">
					<div class="login-form">

						<form action="guideApply.do" method="post" id="guideForm"  enctype="multipart/form-data">

							<!-- 							타이틀 -->
							<div class="form-group">
								<label for="exampleInputPassword1">Title</label> <input
									name="title" type="text" id="applyTitle" class="form-control"
									placeholder="Title">
							</div>


							<!--투어날짜 정하기 -->

							<div class="form-group">
								<label for="exampleInputPassword1">TourDate</label> <input
									type="Date" name="date" class="form-control"
									id="applyDate" placeholder="contents">
							</div>

							<label>Time</label> <select class="form-control" id=applyTime name="time" onchange="check()">
								<option value=""> 시간을 선택해주세요.</option>
								<option value="6">06:00 ~ 08:00</option>
								<option value="7">07:00 ~ 09:00</option>
								<option value="8">08:00 ~ 10:00</option>
								<option value="9">09:00 ~ 11:00</option>
								<option value="10">10:00 ~ 12:00</option>
								<option value="11">11:00 ~ 13:00</option>
								<option value="12">12:00 ~ 14:00</option>
								<option value="13">13:00 ~ 15:00</option>
								<option value="14">14:00 ~ 16:00</option>
								<option value="15">15:00 ~ 17:00</option>
								<option value="16">16:00 ~ 18:00</option>
								<option value="17">17:00 ~ 19:00</option>
								<option value="18">18:00 ~ 20:00</option>
								<option value="19">19:00 ~ 21:00</option>
								<option value="20">20:00 ~ 22:00</option>
								<option value="21">21:00 ~ 23:00</option>
								<option value="22">22:00 ~ 24:00</option>
							</select> <br>
							<span id="timeCheck" style="color: crimson;"> </span>

							<!-- 컨텐츠 -->
							<div class="form-group">
								<label for="exampleInputPassword1">contents</label> <input
									name="contents" type="text" class="form-control" id="applyContents"
									placeholder="contents">
							</div>

							<label>Max Person</label> <select class="form-control"
								name="maxPerson">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="100">no Matter</option>

							</select> <br> 
							
							<!-- 언어 -->
							<div class="form-group">
								<label for="exampleInputPassword1">Language</label> <input
									name="language" type="text" class="form-control" id="applyLanguage" 
									placeholder="language">
							</div>
							
							<div class="form-group">
								<label for="exampleInputFile">투어 파일 업로드</label> <input
									type="file" name="image" id="exampleInputFile">
							</div>

							<input type="hidden" id="placeId" name="placeId"
								value="${place.id }"> <input type="hidden" id="guideId"
								name="guideId" value="">

							<button type="button" onclick="applysubmit()">Apply</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- login modal-about -->
	<div class="modal bnr-modal fade" id="loginModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="background-color: currentColor;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div id="loginF" class="modal-body modal-spa"
					style="display: block; text-align: -webkit-center;">

					<span id="loginText" style="color: blanchedalmond;">구글 아이디로
						이용하셈</span>
					<div id="my-signin2"></div>
					<!--<a href="https://accounts.google.com/o/oauth2/auth?client_id=1006094630241-2u32bu1k1komv4nepbmbbvrajogpvvj2.apps.googleusercontent.com&redirect_uri=http://localhost:8080/FreeWalking/oauth.do&scope=https://www.googleapis.com/auth/plus.login&response_type=code"><button type="button">Login with Google</button></a>  -->

				</div>
			</div>
		</div>
	</div>
	<!-- //modal-about -->
	
	<div class="modal bnr-modal fade" id="myTourModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div> 
				<div class="modal-body modal-spa">

					<form action="${ctx }/myPage.do" method="post" id="myPageform">
						<input type="hidden" value="" id="datailTid"> 
						<input type="hidden" value="" id="applyId" name="userId">
						<input type="hidden" value="" id="hiddenDate">
					</form> 

					<img src="" class="img-responsive" alt="" id="tourImg"/>
					<div style="display: flex;">
					<h4 id="tourTitle"></h4><h5 id="tourGuide"></h5>
					</div>
					<p id="tourContent"></p>
					<p id="tourlanguage" style="font-weight: bold;"></p>
					<div class="person" style="text-align: center; margin:1em;">
						<h3>Person</h3>
						<div class="quantity">
							<div class="quantity-select">
								<div class="entry value-minus">&nbsp;</div>
								<div class="entry value" id="pcnt">1</div>
								<div class="entry value-plus active">&nbsp;</div>
							</div>
						</div>
					</div>
					<div style="text-align: center;">
					<button type="button" class="ApplyTour" onclick="tourApply()">신청</button>
					</div>
				</div> 
			</div>
		</div>
	</div>
	<!-- //modal-about -->
	
	<div class="modal bnr-modal fade" id="applyOk" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="background-color: indianred;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div id="loginF" class="modal-body modal-spa"
					style="display: block; text-align: -webkit-center;">

					<span id="resultText" style="color: blanchedalmond;"></span>
				</div>
			</div>
		</div>
	</div>
	<!-- //modal-about -->


	<!-- 샌드 메세지 -->
	<div class="modal bnr-modal fade" id="sendMessage" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div> 
				<div class="modal-body modal-spa" id="userList">
				<!-- 	<h4>아이디를 선택하세요</h4>
					<select class="form-control" id="selectId" name="selectId" >
						<option value=""> all </option>
						<option value="6">06:00 ~ 08:00</option>
					</select>
					<br>
					<h4>보낼 메시지를 입력하세요</h4>
					<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Message Input max size 50" maxlength="50">
					<br>
					<button type="button" onclick="" class="sbBtn">Send</button>  -->
				</div> 
			</div>
		</div>
	</div>
	<!-- //modal-about -->



	<!-- Custom-JavaScript-File-Links -->

	<!-- Default-JavaScript -->
	<script type="text/javascript"
		src="${ctx }/resource/js/jquery-2.2.3.min.js"></script>



	<!-- Time-JavaScript -->
	<script>
		function startTime() {
			var today = new Date();
			var h = today.getHours();
			var m = today.getMinutes();
			var s = today.getSeconds();
			m = checkTime(m);
			s = checkTime(s);
			document.getElementById('txt').innerHTML = h + ":" + m + ":" + s;
			var t = setTimeout(startTime, 500);
		}
		function checkTime(i) {
			if (i < 10) {
				i = "0" + i
			};
			return i;
		}
	</script>
	<!-- //Time-JavaScript -->

	<!-- Weather-Widget-JavaScript -->
	<script src="${ctx }/resource/js/skycons.js?ver=4"></script>
	<script>
		var icons = new Skycons({
			"color" : "#FFFFFF"
		}), list = [ "clear-day" ], i;
		for (i = list.length; i--;)
			icons.set(list[i], list[i]);
		icons.play();
	</script>
	<script>
		var icons = new Skycons({
			"color" : "#FFFFFF"
		}), list = [ "clear-day", "clear-night", "partly-cloudy-day",
				"partly-cloudy-night", "cloudy", "rain", "sleet", "snow",
				"wind", "fog" ], i;

		for (i = list.length; i--;) {
			var weatherType = list[i], elements = document
					.getElementsByClassName(weatherType);
			for (e = elements.length; e--;) {
				icons.set(elements[e], weatherType);
			}
		}

		icons.play();
	</script>
	<!--//Weather-Widget-JavaScript -->

	<!-- Owl-Carousel-JavaScript -->
	<script src="${ctx }/resource/js/owl.carousel.js?ver=4"></script>
	<script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel({
				autoPlay : 3000,
				items : 6,
				itemsDesktop : [ 1024, 4 ],
				itemsDesktopSmall : [ 640, 3 ]
			});
		});
	</script>
	<!-- //Owl-Carousel-JavaScript -->

	<script type="text/javascript">
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!
		var yyyy = today.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}

		today = yyyy + '-' + mm + '-' + dd;

		var maxday = new Date();
		var dd = maxday.getDate();
		var mm = maxday.getMonth() + 2; //January is 0!
		var yyyy = maxday.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}

		maxday = yyyy + '-' + mm + '-' + dd;

		document.getElementById("firstDate").min = today;
		document.getElementById("firstDate").value = today;
		
		document.getElementById("applyDate").min = today;
		document.getElementById("applyDate").value = today;

		document.getElementById("lastDate").min = today;
		document.getElementById("lastDate").value = today;
	</script>

	<!-- //Custom-JavaScript-File-Links -->

	<script>
	var email;
	
		function onSuccess(googleUser) {
			var profile = googleUser.getBasicProfile();
			var imageurl = profile.getImageUrl();
			var name = profile.getName();
			email = profile.getEmail();
			
 			document.getElementById("guideId").value = email;
			document.getElementById("applyId").value = email;
			document.getElementById("postApplyId").value = email;
			
			console.log(email);
			
			$('#profileImg').attr("src", imageurl)
			$('.loginS').css("display", "block");
			$('#gA').css("display", "inline-block");
			$('#my-signin2').css("display", "none");
			$('#loginText').html("환영합니다 " + name + "님");
			$('#loginSpan').html("LogOut");
			$('#loginNav').attr("href", "#");
			$('#loginNav').click(function signOut() {
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
					location.reload();
				});
			});

		}
		function onFailure(error) {
			console.log(error);
		}
		function renderButton() {
			gapi.signin2.render('my-signin2', {
				'scope' : 'profile email',
				'width' : 240,
				'height' : 50,
				'longtitle' : true,
				'theme' : 'dark',
				'onsuccess' : onSuccess,
				'onfailure' : onFailure
			});
		}
	</script>

	<!-- 투어관련 ajax -->
	<script>
		var findApply = function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/findApply.ajax",
				type : "post",
				data : {
					firstDate : $("#firstDate").val(),
					lastDate : $("#lastDate").val(),
					people : $("#people").val(),
					placeId : $("#placeId").val()
				},
				success : displayTourApply
			});
		};

		var displayTourApply = function(resultData) {
			var tourApplyHtml = "";
			tourApplyHtml+= '<div id="blog" class="services blog">';
			tourApplyHtml+= '<div class="container">';  
			tourApplyHtml+= '<div class="blog-agileinfo">';
				
			if(resultData.length == 0){
				tourApplyHtml+= '<p style="text-align: center;font-weight: bold;">해당 기간에 투어가 존재 하지 않습니다. 기간을 다시 선택하세요.</p>';
			}
			
			$.each(resultData, function(index, tour) {

				tourApplyHtml += '<div class="col-md-4 col-sm-6 blog-w3lgrids">';
				tourApplyHtml += '<div class="blog-gridtext">';
				tourApplyHtml += '<div class="blog-w3img">';
				tourApplyHtml += '<a href="#" data-toggle="modal">';
				tourApplyHtml += '<img src="/img/' + tour.file.name + '" class="img-responsive zoom-img" alt="" / ></a>';
				tourApplyHtml += '</div>';
				tourApplyHtml += '<div class="blog-w3imgtext">';
				tourApplyHtml += '<br>';
				tourApplyHtml += '<h4>'  + tour.title + ' </h4>';
				tourApplyHtml += '<p class="w3-agilep">';
				tourApplyHtml += 'Posted By &nbsp;<a href="#">' + tour.guideId + '</a> <br/> Now Person/Max Person &nbsp;&nbsp; ' + tour.currentPerson + '/' + tour.maxPerson 
				tourApplyHtml += '<br/> Date :  ' + tour.startDate + ' ~ ' + tour.endDate + '</p>';
				tourApplyHtml += "<a href='#myTourModal' data-imgsrc='/img/"+tour.file.name+"' data-tid='"+tour.id+"' data-tlang='"+tour.language+"' data-hdate='"+tour.startDate+"' data-guide='"+tour.guideId+"' data-tourtitle='"+tour.title+"' data-contents='"+tour.contents+"'  onclick='TourImgShow()' class='wthree-btn w3btn2 w3btn2a' data-toggle='modal' >Read more</a>";
				tourApplyHtml += '</div> </div> </div>';
			});

			tourApplyHtml+= '</div> </div> </div>';
			$('#ContentArea').empty();
			$("#ContentArea").append(tourApplyHtml);
		};
	</script>
	<!-- 투어관련 -->

	<script type="text/javascript">
	var timeFlag = true;
	
	function check() {
		$.ajax({
			url : "${pageContext.request.contextPath}/guideApplyCheck.ajax",
			type : "post",
			data : {
				date : $("#applyDate").val(),
				time : $("#applyTime").val(),
				guideId : $("#guideId").val()
			},
			success : function(resultData) {
				if(resultData == "false") {
					$("#timeCheck").text("중복된 신청입니다.")
					timeFlag = false;
					return false;
				} else if (resultData == "timeOver") {
					$("#timeCheck").text("지난 시간입니다.")
					timeFlag = false;
					return false;
				} else if (resultData == "alreadyTourist")  {
					$("#timeCheck").text("동시간대에 여행객으로 신청중입니다.")
					timeFlag = false;
				}
				else {
					$("#timeCheck").text("가이드 신청이 가능합니다.")
					timeFlag = true;
					return false;
				}
			}
		});
	}
	
	var applysubmit = function() {
		if($("#applyTitle").val() == "") {
			jQuery('#applyOk').modal();
			$('#resultText').text('제목을 입력하시오.');
			return false;
		} else if ($("#applyContents").val() == "") {
			jQuery('#applyOk').modal();
			$('#resultText').text('내용을 입력하시오.');
			return false;
		} else if ($('#applyTime').val() == "") {
			jQuery('#applyOk').modal();
			$('#resultText').text('시간을 선택해주세요.');
			return false;
		} else if ($("#applyLanguage").val() == "") {
			jQuery('#applyOk').modal();
			$('#resultText').text('사용 가능 언어를 입력하시오.');
			return false;
		} else if (!timeFlag) {
			jQuery('#applyOk').modal();
			$('#resultText').text('시간을 다시 정해주세요.');
			return false;
		} else {
			jQuery('#applyOk').modal();
			$('#resultText').text('가이드를 시작합니다.');
			setTimeout(function(){
				$('#guideForm').submit();
			},2000);
		}
	
	};
	
	</script>
	

	<script>
		var TourImgShow = function(){
			$('#myTourModal').on('show.bs.modal', function (event) {
				var imgsrc = $(event.relatedTarget).data('imgsrc'); // Button that triggered the modal
				// Extract info from data-* attributes
				var tourtitle = $(event.relatedTarget).data('tourtitle');
				var contents = $(event.relatedTarget).data('contents');
				var guide = $(event.relatedTarget).data('guide');
				var tid = $(event.relatedTarget).data('tid');
				var hDate = $(event.relatedTarget).data('hdate');
				var tourlang = $(event.relatedTarget).data('tlang');
			    $('#tourImg').attr('src',imgsrc);
			    $('#tourTitle').text(tourtitle);
			    $('#tourContent').text(contents);
			    $('#tourGuide').text(guide);
			    $('#pcnt').text('1');
			    $('#datailTid').val(tid);
			    $('#hiddenDate').val(hDate);
			    $('#tourlanguage').text('사용언어 : '+tourlang);
			});
			
		}
	
	</script>

	<!--quantity-->
	<script>
		$('.value-plus').on('click',function() {
			var divUpd = $(this).parent().find('.value'), newVal = parseInt(
					divUpd.text(), 10) + 1;
			divUpd.text(newVal);
		});

		$('.value-minus').on('click',function() {
			var divUpd = $(this).parent().find('.value'), newVal = parseInt(
					divUpd.text(), 10) - 1;
			if (newVal >= 1)
				divUpd.text(newVal);
		});
	</script>
	<!--//quantity-->


	<script>
	var tourApply = function(){
		var tid =  $('#datailTid').val();
		var pcnt = $('#pcnt').text();
		var guideId = $('#guideId').val();
		var hDate = $('#hiddenDate').val();
		var Gourl="${ctx}/tourApply.do?tid="+tid+"&pcnt="+pcnt+"&aid="+guideId+"&hiddenDate="+hDate;
		
		$.ajax({
			url : Gourl,
			type : "post",
			success : function(resultData) {

				if(resultData == 'ok') {
					jQuery('#applyOk').modal();
					$('#resultText').text('신청이 완료되었습니다.');
					jQuery('#myTourModal').modal('hide');
				} else if (resultData == 'over') {
					jQuery('#applyOk').modal();
					$('#resultText').text('최대 인원 초과로 신청이 실패했습니다.');
					jQuery('#myTourModal').modal('hide');
				} else if (resultData == 'alreadyTour') {
					jQuery('#applyOk').modal();
					$('#resultText').text('이미 신청하셨습니다.');
					jQuery('#myTourModal').modal('hide');
				} else if (resultData == 'alreadyGuide') {
					jQuery('#applyOk').modal();
					$('#resultText').text('그 시간대에 가이드 중입니다.');
					jQuery('#myTourModal').modal('hide');
				}
				findApply();

			}
		});
		
		
	}
	</script>
	
	<script>
	var myPage = function(){
		$('#myPageform').submit();
		
	}
	
	var postList = function() {
		$('#postForm').submit();
	}
	
	</script>
	
	
	<!-- 메세지 ajax -->
	<script>
		var findMessage = function() {
			$.ajax({
				url : "${ctx}/getmessage.ajax",
				type : "post",
				data : {
					uid : $("#applyId").val()
				},
				success : displayMessage
			});
		};

		var displayMessage = function(resultData) {
			var messageHtml = "";
			
			$.each(resultData, function(index, meesage) {
				messageHtml += '<div style="display: flex;width:100%;">';
				messageHtml += '<div style=" text-align: center; width: 20%; "><a href="#" onclick="showResend()"><span id="resendId" class="reMsgid">'+meesage.fromMemberId+'</span></a></div>';
				messageHtml += '<div style=" text-align: center; width: 20%; "><span>'+meesage.registDate+'</span></div>';
				messageHtml += '<div style=" text-align: center; width: 60%; "><span style="text-align: center;">'+meesage.contents+'</span>'+
								'<a href="#" onclick="dropMessage('+meesage.id+')">'+
								'<button type="button" class="close" aria-label="Close" style="color: coral;">'+
								'<span aria-hidden="true">&times;</span>'+
								'</button>'+
								'</a></div>';
				messageHtml += '</div>';
			});
			
			$('#messageContents').empty();
			$("#messageContents").append(messageHtml);
		};
		
		var dropMessage = function(id) {
			
			console.log(id);
			
			$.ajax({
				url : "${ctx}/delmessage.ajax",
				type : "post",
				data : {
					mid : id
				},
				success : function(redata){
					console.log(redata);
					findMessage();
				}
			});
		};
		
		
		var showResend = function(){
			
			var resendedId = $('#resendId').text();
			var userListHtml = "<h4>아이디를 선택하세요</h4>";
			userListHtml += '<select class="form-control" id="selectId" name="selectId" >';
			userListHtml += '<option value='+resendedId+'>'+resendedId+'<option>';
			userListHtml += '</select><br>';
			userListHtml += '<h4>보낼 메시지를 입력하세요</h4>';
			userListHtml += '<input type="text" class="form-control" placeholder="Message Input max size 50" maxlength="50" id="messageContent">';
			userListHtml +='<br><button type="button" onclick="MessagePost()" class="sbBtn">Send</button>';
			$('#userList').empty();
			$("#userList").append(userListHtml);
			jQuery('#sendMessage').modal();
		};
		
		
		var MessagePost = function(){
			if($("#selectId option:selected").val()==""){
				$('#resultText').text('아이디를 선택해주세요.');
				jQuery('#sendOk').modal();
				return false;
			}
			
			$.ajax({
				url : "${ctx}/regmessage.ajax",
				type : "post",
				data : {
					uid : $("#selectId option:selected").val(),
					content : $('#messageContent').val(),
					fromid : email
				},
				success : function(){
					
					$('#resultText').text('메세지가 전송되었습니다.');
					jQuery('#applyOk').modal();
					jQuery('#sendMessage').modal('hide');
				}
			});
			
			
		};
	</script>
	<!-- 메세지 -->
	

	<script
		src="https://apis.google.com/js/platform.js?onload=renderButton" async
		defer></script>


	<%@ include file="./footer.jspf"%>
</body>
</html>