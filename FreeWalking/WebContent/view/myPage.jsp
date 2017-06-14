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
				<li><a href="#messageModal" onclick="findMessage()" data-toggle="modal" class="loginS" style="display: none;"><span>Message</span></a></li>
				<li><a href="#" onclick="myPage()" class="loginS" style="display: none;"><span>MyTour</span></a></li>
			</ul>
			<span aria-hidden="true" class="stretchy-nav-bg"></span>
		</nav>
		
		<!-- message modal -->
		<div class="modal bnr-modal fade" id="messageModal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document" style="width: 90%">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body modal-spa" >
						<h4 style="text-align: center;">Message Box</h4>
						<br>
						<div style="display: inline-flex;width: 100%;color: coral;font-weight: bold;">
							<div style=" text-align: center; width: 20%; "><span>보낸사람  </span></div>
							<div style=" text-align: center; width: 20%; "><span>보낸시간  </span></div>
							<div style=" text-align: center; width: 60%; "><span style="text-align: center;"> 내용</span></div>
						</div>
						<br><br>
						<div id="messageContents" style="width: 100%;">
							<div style=" text-align: center; width: 20%; "><span>lll101010s2@gmail.com  </span></div>
							<div style=" text-align: center; width: 20%; "><span>2017-06-14 11:00  </span></div>
							<div style=" text-align: center; width: 60%; "><span style="text-align: center;"> dasdsadsad</span>
								<a href="#">
									<button type="button" class="close" aria-label="Close" style="color: coral;">
									<span aria-hidden="true">&times;</span>
									</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	<!-- news -->
	<div class="news" id="news" style="background: url(${ctx}/resource/images/mbg.jpg) no-repeat 0px 0px; opacity: 0.8; background-size: 100% 120%;  ">
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
							
							<a href="#" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal" onclick="showMsgList(${guide.id})" style="margin-top: 50px; "
							>Send Message</a>
							
						</div>
						<div class="col-md-9 col-xs-9 date-info">
							<h5><a href="#myModal" data-toggle="modal" style="color: black;">${guide.title }</a></h5>
							<p style="margin: 0px; color:cornflowerblue ">Start Date : ${guide.startDate } ~<br>End Date : ${guide.endDate }</p>
							<p>Address <br>${guide.place.address }</p>
							<a href="#myModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal" 
							data-mtitle="${guide.title}" 
							data-mcontents="${guide.contents }"
							data-mimgsrc="/img/${guide.file.name }"
							data-mlang="${guide.language }"
							onclick="showRead()"
							
							>Read more</a>
							<a href="#mapModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							data-pcontents="${guide.place.contents }"
							data-paddress="${guide.place.address }"
							data-psrc="https://www.google.com/maps/embed/v1/place?key=AIzaSyDx6PhbZtEg6VsBhod8enpuRaFK4LQY5ZU
   								 &q=${guide.place.address }"
							onclick="showMap()">Location</a>
							<a href="${ctx }/cancelGuide.do?tourId=${guide.id }&userId=${guide.guideId}" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							>Cancel Guide</a>
							
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
							<h5><a href="#" data-toggle="modal" onclick="showMsgGuide('${tour.guideId}')">Guide ID : ${tour.guideId }</a></h5>
							<p style="margin: 0px; color:cornflowerblue ">Start Date : ${tour.startDate } ~<br>End Date : ${tour.endDate }</p>
							<p>Address  <br>${tour.place.address }</p>
							<a href="#myModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							data-mtitle="${tour.title}" 
							data-mcontents="${tour.contents }"
							data-mimgsrc="/img/${tour.file.name }"
							data-mlang="${tour.language }"
							onclick="showRead()">Read more</a> 
							<a href="#mapModal" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							data-pcontents="${tour.place.contents }"
							data-paddress="${tour.place.address }"
							data-psrc="https://www.google.com/maps/embed/v1/place?key=AIzaSyDx6PhbZtEg6VsBhod8enpuRaFK4LQY5ZU
   								 &q=${tour.place.address}"
							onclick="showMap()">Location</a>
							<a href="${ctx }/cancelTour.do?tourId=${guide.id }&userId=${guide.guideId}" class="wthree-btn w3btn2 w3btn2a" data-toggle="modal"
							>Cancel Tour</a>
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
	
	<!-- 리드미 -->
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
					<p id="ModalLang" style="font-weight: bold;"></p>
				</div> 
			</div>
		</div>
	</div>
	<!-- //modal-about -->  
	
	
	<!-- 지도-about -->
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
	
	
	<!-- 샌드 메세지 -->
	<div class="modal bnr-modal fade" id="sendMessage" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div> 
				<div class="modal-body modal-spa" id="userList">
				<!-- 	<h4>아이디를 선택하세요</h4>
					<select class="form-control" id="selectId" name="selectId" >
						<option value=""> all </option>
						<option value="6">06:00 ~ 08:00</option>
					</select>
					<br>
					<h4>보낼 메시지를 입력하세요</h4>
					<input type="text" class="form-control" id="exampleInputEmail1" placeholder="Message Input max size 50" maxlength="50">
					<br>
					<button type="button" onclick="" class="sbBtn">Send</button>  -->
				</div> 
			</div>
		</div>
	</div>
	<!-- //modal-about -->
	
	<!-- ok창 -->
	<div class="modal bnr-modal fade" id="sendOk" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="background-color: indianred;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div id="loginF" class="modal-body modal-spa"
					style="display: block; text-align: -webkit-center;">

					<span id="resultText" style="color: blanchedalmond;"></span>
				</div>
			</div>
		</div>
	</div>
	<!-- //modal-about -->


	<script>
	
	var email = "";
	
		function onSuccess(googleUser) {
			var profile = googleUser.getBasicProfile();
			var imageurl = profile.getImageUrl();
			var name = profile.getName();
			email = profile.getEmail();

			
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
				var modallang = $(event.relatedTarget).data('mlang');
				
				$("#ModalLang").text('사용언어 : '+modallang);
			 	$('#ModalTitle').text(modaltitle);
			 	$('#ModalContents').text(modalcontents);
			    $('#ModalImg').attr('src', mimgsrc);
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
	
	var showMsgList = function(tourid){
		$.ajax({
			url : "${ctx}/finduser.ajax",
			type : "post",
			data : {
				tid : tourid
			},
			success : displayUserList
		});
	}
	var showMsgGuide = function(guideid) {
	
		var userListHtml = "<h4>아이디를 선택하세요</h4>";
		userListHtml += '<select class="form-control" id="selectId" name="selectId" >';
		userListHtml += '<option value="'+guideid+'">'+guideid+'</option>';
		userListHtml += '</select><br>';
		userListHtml += '<h4>보낼 메시지를 입력하세요</h4>';
		userListHtml += '<input type="text" class="form-control" placeholder="Message Input max size 50" maxlength="50" id="messageContent">';
		userListHtml +='<br><button type="button" onclick="MessagePost()" class="sbBtn">Send</button>';
		$('#userList').empty();
		$("#userList").append(userListHtml);
		jQuery('#sendMessage').modal();
		
	}
	
	var showResend = function(){
		
		var resendedId = $('#resendId').text();
		var userListHtml = "<h4>아이디를 선택하세요</h4>";
		userListHtml += '<select class="form-control" id="selectId" name="selectId" >';
		userListHtml += '<option value='+resendedId+'>'+resendedId+'<option>';
		userListHtml += '</select><br>';
		userListHtml += '<h4>보낼 메시지를 입력하세요</h4>';
		userListHtml += '<input type="text" class="form-control" placeholder="Message Input max size 50" maxlength="50" id="messageContent">';
		userListHtml +='<br><button type="button" onclick="MessagePost()" class="sbBtn">Send</button>';
		$('#userList').empty();
		$("#userList").append(userListHtml);
		jQuery('#sendMessage').modal();
	}
	
	
	
	var displayUserList = function(resultData) {
		var userListHtml = "<h4>아이디를 선택하세요</h4>";
		userListHtml += '<select class="form-control" id="selectId" name="selectId" >';
		userListHtml += '<option value=""> 아이디를 선택해주세요 </option>';
		
		$.each(resultData, function(index, user) {
			userListHtml += '<option value="'+user.memberId+'">'+user.memberId+'</option>';
			
		});
		userListHtml += '</select><br>';
		userListHtml += '<h4>보낼 메시지를 입력하세요</h4>';
		userListHtml += '<input type="text" class="form-control" placeholder="Message Input max size 50" maxlength="50" id="messageContent">';
		userListHtml +='<br><button type="button" onclick="MessagePost()" class="sbBtn">Send</button>';
		$('#userList').empty();
		$("#userList").append(userListHtml);
		jQuery('#sendMessage').modal();
	};
	
	var MessagePost = function(){
		if($("#selectId option:selected").val()==""){
			$('#resultText').text('아이디를 선택해주세요.');
			jQuery('#sendOk').modal();
			return false;
		}
		
		$.ajax({
			url : "${ctx}/regmessage.ajax",
			type : "post",
			data : {
				uid : $("#selectId option:selected").val(),
				content : $('#messageContent').val(),
				fromid : email
			},
			success : function(){
				
				$('#resultText').text('메세지가 전송되었습니다.');
				jQuery('#sendOk').modal();
				jQuery('#sendMessage').modal('hide');
			}
		});
		
		
	}
	
	</script>
	
	
	<!-- 메세지 ajax -->
	<script>
		var findMessage = function() {
			$.ajax({
				url : "${ctx}/getmessage.ajax",
				type : "post",
				data : {
					uid : email
				},
				success : displayMessage
			});
		};

		var displayMessage = function(resultData) {
			var messageHtml = "";
			
			$.each(resultData, function(index, meesage) {
				messageHtml += '<div style="display: flex;width:100%;">';
				messageHtml += '<div style=" text-align: center; width: 20%; "><a href="#" onclick="showResend()"><span id="resendId" class="reMsgid">'+meesage.fromMemberId+'</span></a></div>';
				messageHtml += '<div style=" text-align: center; width: 20%; "><span>'+meesage.registDate+'</span></div>';
				messageHtml += '<div style=" text-align: center; width: 60%; "><span style="text-align: center;">'+meesage.contents+'</span>'+
								'<a href="#" onclick="dropMessage('+meesage.id+')">'+
								'<button type="button" class="close" aria-label="Close" style="color: coral;">'+
								'<span aria-hidden="true">&times;</span>'+
								'</button>'+
								'</a></div>';
				messageHtml += '</div>';
			});
			
			$('#messageContents').empty();
			$("#messageContents").append(messageHtml);
		};
		
		var dropMessage = function(id) {
			
			console.log(id);
			
			$.ajax({
				url : "${ctx}/delmessage.ajax",
				type : "post",
				data : {
					mid : id
				},
				success : function(redata){
					console.log(redata);
					findMessage();
				}
			});
		};
	</script>
	<!-- 메세지 -->

<script
		src="https://apis.google.com/js/platform.js?onload=renderButton" async
		defer></script>
<%@ include file="./footer.jspf" %>
</body>
</html>