<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<h1><a href="index.jsp">Free Walking Tour</a></h1>
				</div>  
				<div class="clearfix"> </div>
			</div>
		</div>
		<!-- //header -->
		<!-- top-nav -->
		<nav class="cd-stretchy-nav edit-content">
			<a class="cd-nav-trigger" href="#0"> Menu <span aria-hidden="true"></span> </a>
			<ul>
				<li><a href="#home" class="scroll"><span>Home</span></a></li>
				<li><a href="#about" class="scroll"><span>About</span></a></li>
				<li><a href="#services" class="scroll"><span>Services</span></a></li>
				<li><a href="#portfolio" class="scroll"><span>Portfolio</span></a></li> 
				<li><a href="#blog" class="scroll"><span>Blog</span></a></li>
				<li><a href="#news" class="scroll"><span>News</span></a></li> 
				<li><a href="#contact" class="scroll"><span>Contact</span></a></li>
			</ul> 
			<span aria-hidden="true" class="stretchy-nav-bg"></span>
		</nav> 
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
								<p>25°C</p>
							</div>
							<div class="w3temperatureaits-grid w3tempimg">
								<figure class="icons agileits w3layouts">
									<canvas class="snow" width="70" class="w3-agileits"
										height="70"></canvas>
								</figure>
							</div>
							<div class="w3temperatureaits-grid w3-agile wthreestats">
								<ul>
									<li class="agiletemp wthree agiletemphumidity w3-agile">40%
										Humidity</li>
									<li
										class="agiletemp agileits-w3layouts agileinfo agiletempwind">4m/s
										NE</li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>

						<div id="owl-demo" class="owl-carousel agileits text-center">
							<div class="item w3threeitem w3threeitem1">
								<h4>SUN</h4>
								<figure class="icons agileits-w3layouts agileits w3layouts">
									<canvas class="snow" width="50" height="50"></canvas>
								</figure>
								<h5>18°C</h5>
							</div>
							<div class="item w3threeitem agileinfo w3threeitem2">
								<h4>MON</h4>
								<figure class="icons wthree agileits w3layouts">
									<canvas id="sleet" width="50" class="w3ls" height="50"></canvas>
								</figure>
								<h5>17°C</h5>
							</div>
							<div class="item w3 w3threeitem w3threeitem3">
								<h4>TUE</h4>
								<figure class="icons agileits w3layouts">
									<canvas id="rain" width="50" height="50"></canvas>
								</figure>
								<h5>17°C</h5>
							</div>
							<div class="item w3threeitem w3threeitem4">
								<h4>WED</h4>
								<figure class="icons agileits w3layouts">
									<canvas id="fog" class="fog" width="50" class="w3ls" height="50"></canvas>
								</figure>
								<h5>17°C</h5>
							</div>
							<div class="item w3threeitem wthree agileinfo w3threeitem5">
								<h4>THU</h4>
								<figure class="icons agileits w3layouts">
									<canvas id="partly-cloudy-day" width="50" height="50"></canvas>
								</figure>
								<h5>17°C</h5>
							</div>
							<div class="item w3threeitem wthree agileinfo w3threeitem6">
								<h4>THU</h4>
								<figure class="icons agileits w3layouts">
									<canvas id="clear-night" class="clear-night" width="50" height="50"></canvas>
								</figure>
								<h5>17°C</h5>
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
						<h5>Date</h5>
						<select class="sel" required="">
							<option value="">Any</option>
							<option value="">$50,000</option>
							<option value="">$75,000</option>
							<option value="">$100,000</option>
							<option value="">$150,000</option>
							<option value="">$500,000</option>
						</select>
					</div>
					<div class="col-md-2 col-xs-4 place-grid">
						<h5>Gender</h5>
						<select class="sel" required="">
							<option value="">All</option>
							<option value="">Man</option>
							<option value="">Woman</option>
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
			<script src="${ctx }/resource/js/skycons.js?ver=3"></script>
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
				var icons = new Skycons({"color": "#FFFFFF"}),
				list = [
					"clear-night", "partly-cloudy-day",	"partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind", "fog"
				],
				i;
				for(i = list.length; i--; )
				icons.set(list[i], list[i]);
				icons.play();
			</script>
		<!--//Weather-Widget-JavaScript -->

		<!-- Owl-Carousel-JavaScript -->
			<script src="${ctx }/resource/js/owl.carousel.js?ver=3"></script>
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

	<!-- //Custom-JavaScript-File-Links -->

		
	
	<%@ include file="./footer.jspf" %>
</body>
</html>