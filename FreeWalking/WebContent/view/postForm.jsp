<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="./header.jspf" %>
<body>


	<div id="contact" class="testimonials contact">
		<div class="container">     
			<h3 class="w3title">Board</h3> 
			<p class="wthree-ttext">글 써 ^▽^</p>
			<div class="contact-w3ls-row">
				<form action="${ctx }/regist.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="placeId" value="${placeId}">
					
					<input name="title" type="text" placeholder="제목" style="width: 100%">
					<input name="userId" type="text" value="${userId}" readonly>
					<input class="email" name="registDate" type="text" value="${registDate }" readonly>
					
					<input type="file" name="image" style="width: 100%"><br>
					
					<textarea name="contents" placeholder="Contents" required=""></textarea>
					<input type="submit" value="SUBMIT">
				</form>
			</div>  
		</div>
	</div>

	
<%@ include file="./footer.jspf" %>
</body>
</html>