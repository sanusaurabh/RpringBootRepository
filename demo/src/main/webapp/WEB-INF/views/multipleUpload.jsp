<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1> Multiple File Upload </h1>
	<form method="post" enctype="multipart/form-data" action="multipleSave">
	    Subject               : <input type ="text" name ="subject" style="width:300px;"><br/>
	    Upload Template File 1: <input type="file" name="file"> <br/>
		Upload Receive File 1 : <input type="file" name="file"> <br/>
		Upload Sender File 2  : <input type="file" name="file"> <br/>
		 
		<br /><br /><input type="submit" value="Send"> 
		</form>
</body>
</html>