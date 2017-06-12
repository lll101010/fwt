<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="./header.jspf" %>
<meta name="google-signin-client_id"
	content="1006094630241-2u32bu1k1komv4nepbmbbvrajogpvvj2.apps.googleusercontent.com"></meta>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	<!-- 구글oauth관련 -->
<body>


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
				<li><a href="#blog" class="scroll"><span>Board</span></a></li>
				<li><a href="#services" class="loginS" style="display: none;"><span>Message</span></a></li>
				<li><a href="#" onclick="myPage()" class="loginS" style="display: none;"><span>MyTour</span></a></li>
			</ul>
			<span aria-hidden="true" class="stretchy-nav-bg"></span>
		</nav>

	<!-- news -->
	<div class="news" id="news" style="background: lightcoral">
		<!-- container -->
		<div class="container" style="background: bisque;">
			<h3 class="w3title" style="padding-top: 1em;" >나의 가이드 목록</h3> 
			<div class="news-wthreegrid"> 
				<c:if test="${empty list}">
					<p>가이드가 존재 하지 않아욥</p>
				</c:if>
					<c:forEach var="guide" items="${list}" varStatus="sts">
					<div class="news-grid-left">
						<div class="col-md-3 col-xs-3 date">
							<p>23</p>
							<span>June</span>
						</div>
						<div class="col-md-9 col-xs-9 date-info">
							<h5><a href="#myModal" data-toggle="modal">${guide.title }</a></h5>
							<p>Proin euismod vehicula vestibulum. Fusce ullamcorper aliquet dolor id egestas. Nulla leo purus, facilisis non cursus ut, egestas sed ipsum.</p>
							<a href="#myModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal">Read more</a> 
						</div>
						<div class="clearfix"> </div>
					</div>
					</c:forEach>
			</div>
		</div>
		<!-- //container -->
		
		<!-- container -->
		<div class="container" style="background: aquamarine; ">
			<h3 class="w3title" style="padding-top: 1em;">나의 신청 목록</h3> 
			<div class="news-wthreegrid"> 
				<c:if test="${empty list}">
					<p>가이드가 존재 하지 않아욥</p>
				</c:if>
					<c:forEach var="guide" items="${list}" varStatus="sts">
					<div class="news-grid-left">
						<div class="col-md-3 col-xs-3 date">
							<p>23</p>
							<span>June</span>
						</div>
						<div class="col-md-9 col-xs-9 date-info">
							<h5><a href="#myModal" data-toggle="modal">${guide.title }</a></h5>
							<p>Proin euismod vehicula vestibulum. Fusce ullamcorper aliquet dolor id egestas. Nulla leo purus, facilisis non cursus ut, egestas sed ipsum.</p>
							<a href="#myModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal">Read more</a> 
						</div>
						<div class="clearfix"> </div>
					</div>
					</c:forEach>
			</div>
			
		</div>
		<!-- //container -->
	</div>
	<!-- //news -->
	
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
	
	<script>
		function onSuccess(googleUser) {
			var profile = googleUser.getBasicProfile();
			var imageurl = profile.getImageUrl();
			var name = profile.getName();
			var email = profile.getEmail();

			console.log(name);
			console.log(email);
			console.log(imageurl);
			
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
					$(location).attr('href', '${ctx}/');
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
	
	<script>
	var myPage = function(){
		
	  location.reload();
		
	}	
	</script>

<script
		src="https://apis.google.com/js/platform.js?onload=renderButton" async
		defer></script>
<%@ include file="./footer.jspf" %>
</body>
</html>