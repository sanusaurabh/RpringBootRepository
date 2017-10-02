<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
<h1>  File Upload  for filter data  </h1>
	<form method="post" enctype="multipart/form-data" action="downloadcsvfileforfilterdata">
	    Upload csv File 1: <input type="file" name="file"> <br/>
	     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<br /><br /><input type="submit" value="Send"> 
		</form>
		</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>