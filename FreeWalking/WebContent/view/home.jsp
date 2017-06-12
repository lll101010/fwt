<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!doctype html>
<html>
<head>
<title>Free Walking Tour</title>
<!-- for-mobile-apps -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Slide Pricing Tables Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<link
	href="//fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200,300,400,700"
	rel="stylesheet">
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link href="${ctx }/homeres/css/style.css?ver=2" rel="stylesheet"
	type="text/css" media="all" />
<script src="${ctx }/homeres/js/jquery-2.1.4.min.js"></script>

</head>
<body id="body">
	<div class="content" id="Main-Content">
		<h1>Free Walking Tour</h1>
		<div class="agileits-top-slider">
			<div class="slider">
				<div class="callbacks_container">
					<ul class="rslides callbacks callbacks1" id="slider4">
<%-- 						<c:choose> --%>
<%-- 							<c:when test="${places eq null || empty places} "> --%>

<%-- 							</c:when> --%>
<%-- 						</c:choose> --%>

<%-- 						<c:otherwise> --%>
							<c:forEach items="${places }" var="place" varStatus="sts">
								<li>
									<div class="pricing" style="opacity: 0.91">
										<div class="pricing-top green-top">
											<h3>${place.country }</h3>
											<p>
												<span>${place.name }</span>/seoul
											</p>
										</div>
										<div class="pricing-bottom">
											<div class="pricing-bottom-top">
												<p>${place.contents }</p>
											</div>
											<div class="pricing-bottom-bottom">

												<p>
													<span>65GB </span> today guide
												</p>
												<p>
													<span>75</span> total guide
												</p>
												<p>Address</p>
												<p>
													<span>${place.address }</span>
												</p>
											</div>
											<div class="buy-button">
												<a href="${ctx }/index.do?id=${place.id}">Show Guide</a>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
<%-- 						</c:otherwise> --%>

						<!-- 						<li> -->
						<!-- 							<div class="pricing"> -->
						<!-- 								<div class="pricing-top blue-top"> -->
						<!-- 									<h3>Corporate</h3> -->
						<!-- 									<p> -->
						<!-- 										$<span>70</span>/month -->
						<!-- 									</p> -->
						<!-- 								</div> -->
						<!-- 								<div class="pricing-bottom"> -->
						<!-- 									<div class="pricing-bottom-top"> -->
						<!-- 										<p>Lorem ipsum dolor sit amet, consectetur adipiscing -->
						<!-- 											elit. Donec augue erat, euismod non tincidunt at</p> -->
						<!-- 									</div> -->
						<!-- 									<div class="pricing-bottom-bottom"> -->
						<!-- 										<p> -->
						<!-- 											<span>Unlimited</span> Email Addresses -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>85GB </span> of Storage -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>65</span> Databases -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>30</span> Domains -->
						<!-- 										</p> -->
						<!-- 										<p class="text"> -->
						<!-- 											<span>24/7</span> Unlimited Support -->
						<!-- 										</p> -->
						<!-- 									</div> -->
						<!-- 									<div class="buy-button"> -->
						<!-- 										<a class="popup-with-zoom-anim" href="#small-dialog">Sign -->
						<!-- 											Up</a> -->
						<!-- 									</div> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 						</li> -->
						<!-- 						<li> -->
						<!-- 							<div class="pricing"> -->
						<!-- 								<div class="pricing-top"> -->
						<!-- 									<h3>Personal</h3> -->
						<!-- 									<p> -->
						<!-- 										$<span>35</span>/month -->
						<!-- 									</p> -->
						<!-- 								</div> -->
						<!-- 								<div class="pricing-bottom"> -->
						<!-- 									<div class="pricing-bottom-top"> -->
						<!-- 										<p>Lorem ipsum dolor sit amet, consectetur adipiscing -->
						<!-- 											elit. Donec augue erat, euismod non tincidunt at</p> -->
						<!-- 									</div> -->
						<!-- 									<div class="pricing-bottom-bottom"> -->
						<!-- 										<p> -->
						<!-- 											<span>Unlimited</span> Email Addresses -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>50GB </span> of Storage -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>55</span> Databases -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>21</span> Domains -->
						<!-- 										</p> -->
						<!-- 										<p class="text"> -->
						<!-- 											<span>24/7</span> Unlimited Support -->
						<!-- 										</p> -->
						<!-- 									</div> -->
						<!-- 									<div class="buy-button"> -->
						<!-- 										<a class="popup-with-zoom-anim" href="#small-dialog">Sign -->
						<!-- 											Up</a> -->
						<!-- 									</div> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 						</li> -->
						<!-- 						<li> -->
						<!-- 							<div class="pricing"> -->
						<!-- 								<div class="pricing-top yellow-top"> -->
						<!-- 									<h3>Business</h3> -->
						<!-- 									<p> -->
						<!-- 										$<span>50</span>/month -->
						<!-- 									</p> -->
						<!-- 								</div> -->
						<!-- 								<div class="pricing-bottom"> -->
						<!-- 									<div class="pricing-bottom-top"> -->
						<!-- 										<p>Lorem ipsum dolor sit amet, consectetur adipiscing -->
						<!-- 											elit. Donec augue erat, euismod non tincidunt at</p> -->
						<!-- 									</div> -->
						<!-- 									<div class="pricing-bottom-bottom"> -->
						<!-- 										<p> -->
						<!-- 											<span>Unlimited</span> Email Addresses -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>65GB </span> of Storage -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>75</span> Databases -->
						<!-- 										</p> -->
						<!-- 										<p> -->
						<!-- 											<span>25</span> Domains -->
						<!-- 										</p> -->
						<!-- 										<p class="text"> -->
						<!-- 											<span>24/7</span> Unlimited Support -->
						<!-- 										</p> -->
						<!-- 									</div> -->
						<!-- 									<div class="buy-button"> -->
						<!-- 										<a class="popup-with-zoom-anim" href="#small-dialog">Sign -->
						<!-- 											Up</a> -->
						<!-- 									</div> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 						</li> -->
					</ul>
				</div>
				<div class="clear"></div>
				<script src="${ctx }/homeres/js/responsiveslides.min.js"></script>
				<script>
					// You can also use "$(window).load(function() {"
					$(function() {
						// Slideshow 4
						$("#slider4")
								.responsiveSlides(
										{
											auto : false,
											pager : true,
											nav : true,
											speed : 0,
											namespace : "callbacks",
											before : function() {
												$('.events')
														.append(
																"<li>before event fired.</li>");
											},
											after : function() {
												$('.events')
														.append(
																"<li>after event fired.</li>");
											}
										});

					});
				</script>
				<!--banner Slider starts Here-->
			</div>
		</div>
		<!--pop-up-grid-->
		<div id="popup">
			<div id="small-dialog" class="mfp-hide">
				<div class="signin-form profile">
					<h3>Sign Up</h3>

					<div class="login-form">
						<form action="${pageContext.request.contextPath} }/member/join.do"
							method="post">

							<input type="text" name="id" placeholder="Id" required="" /> <input
								type="password" name="password" placeholder="Password"
								required=""> <input type="password" name="password"
								placeholder="Confirm Password" required=""> <input
								type="text" name="name" placeholder="Username" required="">
							<input type="email" name="email" placeholder="E-mail" required="">
							<input type="text" name="phone" placeholder="Phone" required="">
							<input type="number" name="age" placeholder="age" required="" />
							<input type="text" name="gender" placeholder="gender" required="" />
							<input type="submit" value="Sign Up">

						</form>
					</div>
				</div>
			</div>
		</div>
		<!--pop-up-grid-->
		<div class="copyright">
			<p class="footer">© 2017 Slide Pricing Tables . All Rights
				Reserved</p>
		</div>
		<script src="${ctx }/homeres/js/jquery.magnific-popup.js"
			type="text/javascript"></script>
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type : 'inline',
					fixedContentPos : false,
					fixedBgPos : true,
					overflowY : 'auto',
					closeBtnInside : true,
					preloader : false,
					midClick : true,
					removalDelay : 300,
					mainClass : 'my-mfp-zoom-in'
				});

			});
		</script>
	</div>

</body>
</html>
