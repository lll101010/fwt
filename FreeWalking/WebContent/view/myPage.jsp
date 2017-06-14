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
	<div class="news" id="news" style="background: url(${ctx}/resource/images/badpark.jpg) no-repeat 0px 0px; opacity: 0.8; background-size: 100% 100%;  ">
		<!-- container -->
		<div class="container" style="background: azure; opacity: 0.93">
			<h3 class="w3title" style="padding-top: 1em;" >My Guide List</h3> 
			<div class="news-wthreegrid" style="text-align: center;"> 
				<c:if test="${empty guideList}">
					<p class="noList">No Guide List</p>
				</c:if>
					<c:forEach var="guide" items="${guideList}" varStatus="sts">
					<c:set var="count" value="${count+1}" />
					<div class="news-grid-left">
						<div class="col-md-3 col-xs-3 date">
							<p>
								${guide.currentPerson }/${guide.maxPerson }
							</p>
							<span>
								<c:choose>
									<c:when test="${guide.maxPerson eq guide.currentPerson }">모집완료</c:when>
									<c:otherwise>모집중</c:otherwise>
								
								</c:choose>
							</span>
						</div>
						<div class="col-md-9 col-xs-9 date-info">
							<h5><a href="#myModal" data-toggle="modal" style="color: black;">${guide.title }</a></h5>
							<p style="margin: 0px; color:cornflowerblue ">Start Date : ${guide.startDate } ~<br>End Date : ${guide.endDate }</p>
							<p>Address <br>${guide.place.address }</p>
							<a href="#myModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal" 
							data-mtitle="${guide.title}" 
							data-mcontents="${guide.contents }"
							data-mimgsrc="/img/${guide.file.name }"
							onclick="showRead()"
							
							>Read more</a>
							<a href="#mapModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							data-pcontents="${guide.place.contents }"
							data-paddress="${guide.place.address }"
							data-psrc="https://www.google.com/maps/embed/v1/place?key=AIzaSyDx6PhbZtEg6VsBhod8enpuRaFK4LQY5ZU
   								 &q=${guide.place.address }"
							onclick="showMap()">Location</a> 
						</div>
						<div class="clearfix"> </div>
					</div>
					</c:forEach>
			</div>
		</div>
		<!-- //container -->
		
		<!-- container -->
		<div class="container" style="background: azure; opacity: 0.93; border-top:1.1px solid #f44336;">
			<h3 class="w3title" style="padding-top: 1em;">My Tour List</h3> 
			<div class="news-wthreegrid" style="text-align: center;"> 
				<c:if test="${empty tourList}">
					<p class="noList">No Tour List</p>
				</c:if>
					<c:forEach var="tour" items="${tourList}" varStatus="sts">
					<div class="news-grid-left">
						<div class="col-md-3 col-xs-3 date">
							<p>
								${tour.currentPerson }/${tour.maxPerson }
							</p>
							<span>
								<c:choose>
									<c:when test="${tour.status eq '0' }">모집중</c:when>
								</c:choose>
							</span>
						</div>
						<div class="col-md-9 col-xs-9 date-info">
							<h5><a href="#myModal" data-toggle="modal" style="color: black;">${tour.title }</a></h5>
							<h5><a href="#myModal" data-toggle="modal">Guide ID : ${tour.guideId }</a></h5>
							<p style="margin: 0px; color:cornflowerblue ">Start Date : ${tour.startDate } ~<br>End Date : ${tour.endDate }</p>
							<p>Address  <br>${tour.place.address }</p>
							<a href="#myModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							data-mtitle="${tour.title}" 
							data-mcontents="${tour.contents }"
							data-mimgsrc="/img/${tour.file.name }"
							onclick="showRead()">Read more</a> 
							<a href="#mapModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							data-pcontents="${guide.place.contents }"
							data-paddress="${guide.place.address }"
							data-psrc="https://www.google.com/maps/embed/v1/place?key=AIzaSyDx6PhbZtEg6VsBhod8enpuRaFK4LQY5ZU
   								 &q=${tour.place.address}"
							onclick="showMap()">Location</a>
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
	
	
	<div class="modal bnr-modal fade" id="myModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div> 
				<div class="modal-body modal-spa">
					<img src="" class="img-responsive" alt=""/ id="ModalImg">
					<h4 id="ModalTitle"></h4>
					<p id="ModalContents"></p>
				</div> 
			</div>
		</div>
	</div>
	<!-- //modal-about -->  
	
	<!-- modal-about -->
	<div class="modal bnr-modal fade" id="mapModal" tabindex="-1"
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
					<div class="map">
						<iframe
							src="" id="mplacesrc">
						</iframe>
					</div>
					<h4 id="mplacecontents"></h4>
					<p id="mplaceaddress"></p>
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
	
	<script>
	var showRead = function(){
			$('#myModal').on('show.bs.modal', function (event) {
				var mimgsrc = $(event.relatedTarget).data('mimgsrc'); // Button that triggered the modal
				var modaltitle = $(event.relatedTarget).data('mtitle'); // Button that triggered the modal
				var modalcontents = $(event.relatedTarget).data('mcontents'); 
			 	$('#ModalTitle').text(modaltitle);
			 	$('#ModalContents').text(modalcontents);
			    $('#ModalImg').attr('src', mimgsrc);
				console.log(modaltitle);
			});
	}
	var showMap = function(){
		$('#mapModal').on('show.bs.modal', function (event) {
			var mapsrc = $(event.relatedTarget).data('psrc'); // Button that triggered the modal
			var mapaddress = $(event.relatedTarget).data('paddress'); // Button that triggered the modal
			var mapcontents = $(event.relatedTarget).data('pcontents'); 
		 	$('#mplacecontents').text(mapcontents);
		 	$('#mplaceaddress').text(mapaddress);
		    $('#mplacesrc').attr('src', mapsrc);
		});
	}
	
	
	</script>

<script
		src="https://apis.google.com/js/platform.js?onload=renderButton" async
		defer></script>
<%@ include file="./footer.jspf" %>
</body>
</html>