<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
<title>Spittr registration</title>
<style type="text/css">
.error{
	font-weight:bold;
	background-color:yellow;
	color:red;
	font-size:85%;
}
</style>
<link type="text/css" href="../styles/color.css" rel="stylesheet"/>
</head>
<body>
<h1>Register</h1>
<div>
	<sf:form method="POST" commandName="spitter">
		First Name:<sf:input path="firstName"  /><sf:errors path="firstName" class="error"></sf:errors><br>
		Last  Name:<sf:input path="lastName"/><sf:errors path="lastName" class="error"></sf:errors><br>
		Username  :<sf:input path="username"/><sf:errors path="username" class="error"></sf:errors><br>
		Password  :<sf:password path="password"/><sf:errors path="password" class="error"></sf:errors><br>
		<input type="submit"  value="Register"/>
	</sf:form>
</div>
</body>
</html>