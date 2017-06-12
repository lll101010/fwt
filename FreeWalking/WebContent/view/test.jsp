<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
function test(id){
  id.setAttribute('class','on');//속성 : class 값으로 on 추가
  alert(id);
  return false;
}
</script>
 
<a href="javascript:;" onclick="test(this);">dd</a> //이벤트객체 선택가능 그리고 a의 href값을 id로 넘겨준다.
 <a href="javascript:test(this);">dd</a> //this값을 받아오지못함
<p onclick="test(this);">dd</p>//이벤트객체 선택가능
</body>
</html>