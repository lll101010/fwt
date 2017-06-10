<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%@ include file="./header.jspf" %>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- Owl-Carousel-CSS --> 
	<link rel="stylesheet" href="${ctx }/resource/css/owl.carousel.css" type="text/css" media="all">
	
<!-- //For-Mobile-Apps -->



<body onload="startTime()"> 
	<!-- banner -->
	<div id="home" class="w3ls-banner">
		<!-- header -->
		<div class="header">
			<div class="container">
				<div class="logo">
					<h1><a href="#">Free Walking Tour</a></h1>
				</div>  
				<div class="clearfix"> </div>
			</div>
		</div>
		<!-- //header -->
		
		
		<!-- 로그인 전 네비 -->
		<nav class="cd-stretchy-nav edit-content">
			<a class="cd-nav-trigger" href="#0"> Menu <span aria-hidden="true"></span> </a>
			<ul>
				<li><a href="${ctx }/view/home.jsp"><span>Home</span></a></li>
				<li><a href="#loginModal" data-toggle="modal" style="content:'\f012';"><span>Login</span></a></li>
				<li><a href="#portfolio" class="scroll"><span>Gallery</span></a></li> 
				<li><a href="#blog" class="scroll"><span>Board</span></a></li>
			</ul> 
			<span aria-hidden="true" class="stretchy-nav-bg"></span>
		</nav> 
		<!-- //top-nav -->
		
		<!-- 로그인 후 네비 -->
		<%-- <nav class="cd-stretchy-nav edit-content">
			<a class="cd-nav-trigger" href="#0"> Menu <span aria-hidden="true"></span> </a>
			<ul>
				<li><a href="${ctx }/view/home.jsp"><span>Home</span></a></li>
				<li><a href="#loginModal" data-toggle="modal"><span>MyInfo</span></a></li>
				<li><a href="#portfolio" class="scroll"><span>Gallery</span></a></li> 
				<li><a href="#blog" class="scroll"><span>Board</span></a></li>
				<li><a href="#services" class="scroll"><span>Message</span></a></li>
				<li><a href="#blog" class="scroll"><span>MyTour</span></a></li>
			</ul> 
			<span aria-hidden="true" class="stretchy-nav-bg"></span>
		</nav>  --%>
		<!-- //top-nav -->
		
		<!-- banner-text -->
		<div class="banner-w3ltext"> 
			<div class="container">
				
				<!-- 날씌 -->
				<div class="weather-widget agileits w3layouts">
					<div class="place agileits w3layouts">
							
						<div class="city agileits-w3layouts agileits w3layouts">
							<h3>Seoul</h3> 
							<h2>한강</h2>
						</div>
						
						<a href="#myModal" class="wthree-btn" data-toggle="modal">Location</a> 
						
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
								document.write("" + dayarray[day] + ", "
										+ montharray[month] + " " + daym + ", "
										+ year + "")
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
									<canvas class="${day4 }" class="fog" width="50" class="w3ls" height="50"></canvas>
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
				<form action="#" method="post">
					
					<div class="col-md-2 col-xs-4 place-grid">
						<h5>First Date</h5>
						<input class="sel2" type="date" name="firstDate" id="firstDate">	
					</div>
					<div class="col-md-2 col-xs-4 place-grid">
						<h5>Last Date</h5>
						<input class="sel2" type="date" name="lastDate" id="lastDate">	
					</div>
					<div class="col-md-2 col-xs-4 place-grid">
						<h5>Select Place</h5>
						<select class="sel" required="">
							<option value="">Place</option>
							<option value="">han gang</option>
							<option value="">kyeong ju</option>
							<option value="">Boston</option> 
							<option value="">Oakland</option>
							<option value="">Chicago</option> 
						</select>
					</div>
					<div class="col-md-2 col-xs-4 place-grid">
						<h5>People</h5>
						<select class="sel" required="">
							<option value="">all</option>
							<option value="">1</option>
							<option value="">2</option>
							<option value="">3</option>
							<option value="">4</option>
						</select>
					</div>
					<div class="col-md-2 col-xs-4 place-grid">
						<h5>Use Language</h5>
						<select class="sel" required="">
							<option value="">Language</option>
							<option value="">Korean</option>
							<option value="">English</option>
							<option value="">Japanese</option>
							<option value="">Chinese</option>
							<option value="">German</option>
						</select>
					</div> 
					<div class="col-md-2 col-xs-4 place-grid"> 
						<input type="submit" value="Search"> 
					</div>
					<div class="clearfix"></div>
				</form>
			</div>
		</div>
	</div>	
	<!-- //banner-bottom --> 
	
	
	<!-- //footer -->	
	<!-- modal-about -->
	<div class="modal bnr-modal fade" id="myModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div>
				<div class="modal-body modal-spa">
					<div class="map">
						<iframe
							src="https://www.google.com/maps/embed/v1/place?key=AIzaSyDx6PhbZtEg6VsBhod8enpuRaFK4LQY5ZU
   								 &q=여의도,한강" allowfullscreen"></iframe>
					</div>
					<h4>여기는 여의도 한강</h4>
					<p>대한민국 서울특별시 영등포구 여의도동 여의동로 330</p>
				</div>
			</div>
		</div>
	</div>
	<!-- //modal-about -->  
	
	
	<!-- modal-about -->
	<div class="modal bnr-modal fade" id="loginModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="background-color:currentColor; ">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div>
				<div id="loginF" class="modal-body modal-spa">
					<div class="login-form">
					<form action="#" method="post">
						<div class="inputs-w3ls">
							<i class="fa fa-envelope" aria-hidden="true" style=" display: block; text-align: center; "></i> <input
								type="email" name="Email" placeholder="Email" required=""
								style="width: 100%;" />
						</div>
					
						<div class="inputs-w3ls">
							<i class="fa fa-key" aria-hidden="true" style=" display: block; text-align: center; "></i> <input
								type="password" name="Password" placeholder="Password"
								required="" style="width: 100%;" />
						</div>
						<a href="https://accounts.google.com/o/oauth2/auth?
    client_id=1006094630241-1m2ff2dh5f6jhvn65jepnh8cfnutvadj.apps.googleusercontent.com
    &redirect_uri=REDIRECT_URI
    &scope=https://www.googleapis.com/auth/plus.login
    &response_type=code"><button type="button">Login with Google</button></a>
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //modal-about -->  
	
	
	<!-- Custom-JavaScript-File-Links -->

		<!-- Default-JavaScript --> <script type="text/javascript" src="${ctx }/resource/js/jquery-2.2.3.min.js"></script>



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
					if (i < 10) {i = "0" + i};
					return i;
				}
			</script>
		<!-- //Time-JavaScript -->

		<!-- Weather-Widget-JavaScript -->
			<script src="${ctx }/resource/js/skycons.js?ver=4"></script>
			<script>
				var icons = new Skycons({"color": "#FFFFFF"}),
				list  = [
					"clear-day"
				],
				i;
				for(i = list.length; i--; )
				icons.set(list[i], list[i]);
				icons.play();
			</script>
			<script>
				var icons = new Skycons({
					"color" : "#FFFFFF"
				}), list = [ "clear-day", "clear-night", "partly-cloudy-day",
						"partly-cloudy-night", "cloudy", "rain", "sleet",
						"snow", "wind", "fog" ], i;

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
						autoPlay: 3000,
						items : 6,
						itemsDesktop : [1024,4],
						itemsDesktopSmall : [640,3]
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
				
				document.getElementById("lastDate").min = today;
				document.getElementById("lastDate").value = today;
			</script>
	
	<!-- //Custom-JavaScript-File-Links -->

		
	
	<%@ include file="./footer.jspf" %>
</body>
</html>