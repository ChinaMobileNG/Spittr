<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
<title>Spittr registration</title>
</head>
<body>
<h1>Register</h1>
<div>
	<sf:form method="POST" commandName="spitter">
		First Name:<sf:input path="firstName"  /><sf:errors path="firstName"></sf:errors><br>
		Last  Name:<sf:input path="lastName"/><sf:errors path="lastName"></sf:errors><br>
		Username  :<sf:input path="username"/><sf:errors path="username"></sf:errors><br>
		Password  :<sf:password path="password"/><sf:errors path="password"></sf:errors><br>
		<input type="submit"  value="Register"/>
	</sf:form>
</div>
</body>
</html>