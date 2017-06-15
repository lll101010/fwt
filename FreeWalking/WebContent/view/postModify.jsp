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
				<form action="${ctx }/post/update.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="placeId" value="${placeId}">
					<input type="hidden" name="id" value="${post.id}">
					
					<input name="title" value="${post.title}" type="text" style="width: 100%">
					<input name="registerId" type="text" value="${post.registerId}" readonly>
					<input class="email" name="registDate" type="text" value="${post.registDate }" readonly>
					
					<div class="form-group">
						<c:forEach items="${files}" var="file" varStatus="sts">
							<img name="image">
						</c:forEach>
					</div>
					
					<textarea name="contents" placeholder="Contents" required="">${post.contents }</textarea>
					<input type="submit" value="SUBMIT">
				</form>
			</div>  
		</div>
	</div>

	
<%@ include file="./footer.jspf" %>
</body>
</html>