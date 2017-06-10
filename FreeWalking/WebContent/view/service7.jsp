<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="./header.jspf" %>
<body>

<!-- contact -->
	<div id="contact" class="testimonials contact">
		<div class="container">     
			<h3 class="w3title">Contact Us</h3> 
			<p class="wthree-ttext">Dolorem eum aliquid ex ea commodi vel illumqui consequatur 
				vel illum qui dolorem eum fugiat quo voluptas</p>
			<div class="contact-w3ls-row">
				<form action="#" method="post">
					<input type="text" name="First Name" placeholder="First Name" required=""> 
					<input class="email" name="Email" type="text" placeholder="Email" required="">
					<textarea name="Message" placeholder="Message" required=""></textarea>
					<input type="submit" value="SUBMIT">
				</form>
			</div>  
		</div>
	</div>
	<!-- //contact -->
	
	<!-- map -->
	<div class="map">
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d343829.1271629402!2d-122.61489066225299!3d47.681214398164556!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x54906aba3648f20b%3A0xc5c4dedaafcead17!2sSeattle%2C+WA+98104!5e0!3m2!1sen!2sin!4v1461914461629"></iframe>
	</div>
	<!-- //map --> 
	



<%@ include file="./footer.jspf" %>
</body>
</html>