<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="./header.jspf" %>

<script type="text/javascript">
	function button_event() {
		if (confirm("정말 삭제하시겠습니까??") == true) { //확인
			location.href = '${ctx}/delete.do?postId=${post.id}&postPlaceId=${post.placeId}&userId=${post.registerId}'
		} else { //취소
			return;
		}
	}
</script>

<script type="text/javascript">
	function button_modify() {
		location.href = '${ctx}/update.do?postId=${post.id}'
	}
</script>

<body>
	<div id="contact" class="testimonials contact">
		<div class="container">     
			<h3 class="w3title">Board</h3> 
			<p class="wthree-ttext"> ^▽^</p>
			<div class="contact-w3ls-row">
				<form>
					<input type="hidden" name="placeId" value="${placeId}">
					
					<input name="title" type="text" value="${post.title}" style="width: 100%" readonly >
					<input name="registerId" type="text" value="${post.registerId}" readonly>
					<input class="email" name="registDate" type="text" value="${post.registDate}" readonly>

					<div class="form-group">
						<c:forEach items="${files}" var="file" varStatus="sts">
							<img name="image" src="${ctx}/image.do?postId=${post.id}&index=${sts.index}"
								style="border-radius: 10px; width: 50%; height: 50%">
						</c:forEach>
					</div>

					<textarea name="contents" placeholder="Contents" required="">${post.contents}</textarea>
					<button type="button" class="btn btn-default" onclick="location.href='${ctx}/postList.do?postPlaceId=${post.placeId}'">목록</button>
					<button type="button" class="btn btn-default" onclick="button_modify();">수정</button>
					<button type="button" class="btn btn-default" onclick="button_event();">삭제</button>
				</form>
			</div>  
		</div>
	</div>

	
<%@ include file="./footer.jspf" %>
</body>
</html>