<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="${ctx }/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${ctx }/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="${ctx }/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${ctx }/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${ctx }/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${ctx }/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Social Buttons CSS -->
    <link href="${ctx }/vendor/bootstrap-social/bootstrap-social.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="./header.jspf"%>
	<div>
	</div>	
	<div class="col-sm-12 col-lg-12">
		<div>
			<h3>게시글 목록 </h3>
		</div>

		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover" border="1">
				<colgroup>
					<col width="100" />
					<col width="100" />
					<col width="100" />
					<col width="100" />
				</colgroup>
				<thead>
					<tr>
						<th width="10%" class="text-center">번호</th>
						<th width="50%" class="text-center">제목</th>
						<th width="20%" class="text-center">회원</th>
						<th width="20%" class="text-center">작성날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${posts eq null || empty posts}">

							<tr>
								<th colspan="5" class="text-center">게시글이 존재하지 않습니다.</th>
							</tr>
						</c:when>
						
						<c:otherwise>
							<c:forEach items="${posts}" var="post" varStatus="sts">
								<tr>
									<td class="text-center" align="center">${sts.count}</td>
									<td class="text-center" align="center"><a href="${ctx}/detail.do?postId=${post.id}">${post.title}</a></td>
									<td class="text-center" align="center">${post.registerId}</td>
									<td class="text-center" align="center">${post.registDate}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<button type="button" class="btn btn-outline btn-primary btn-sm" onclick="location.href='${ctx}/regist.do?placeId=${placeId}&userId=${userId }'">게시글 작성</button>
		</div>
	
	 <!-- jQuery -->
    <script src="${ctx }/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${ctx }/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${ctx }/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="${ctx }/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${ctx }/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${ctx }/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${ctx }/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
	
</body>
</html>