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
  id.setAttribute('class','on');//�Ӽ� : class ������ on �߰�
  alert(id);
  return false;
}
</script>
 
<a href="javascript:;" onclick="test(this);">dd</a> //�̺�Ʈ��ü ���ð��� �׸��� a�� href���� id�� �Ѱ��ش�.
 <a href="javascript:test(this);">dd</a> //this���� �޾ƿ�������
<p onclick="test(this);">dd</p>//�̺�Ʈ��ü ���ð���
</body>
</html>