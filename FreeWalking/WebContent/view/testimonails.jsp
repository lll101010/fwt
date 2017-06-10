<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="./header.jspf" %>
<body>

<!-- testimonials -->
	<div class="testimonials">
		<div class="container"> 
			<h3 class="w3title">Testimonials</h3> 
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="testimonials-grid agileinfo"> 
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam sed do eiusmod.</p>
								<h5>John Doe,<span> Tempor</span></h5>
							</div>
						</li>
						<li>
							<div class="testimonials-grid"> 
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam sed do eiusmod.</p>
								<h5>Elit semper,<span> Veniam</span></h5>
							</div>
						</li>
						<li>
							<div class="testimonials-grid"> 
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam sed do eiusmod.</p>
								<h5>Daniel Nyari,<span> Enim </span></h5>
							</div>
						</li>
					</ul>
				</div>
			</section>
			<!-- FlexSlider -->
			<script defer src="${ctx }/resource/js/jquery.flexslider.js"></script>
			<script type="text/javascript">
			$(window).load(function(){
			  $('.flexslider').flexslider({
				animation: "slide",
				start: function(slider){
				  $('body').removeClass('loading');
				}
			  });
			});
			</script>
			<!-- End-slider-script -->
		</div>
	</div>
	<!-- //testimonials -->

<%@ include file="./footer.jspf" %>
</body>
</html>