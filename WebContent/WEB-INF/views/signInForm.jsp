<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Sign In</title>
</head>
<body>
<h1>Sign In</h1>
<div>
<form method="post">
	Username: <input type="text" name="username"/><br>
	Password: <input type="password" name="password" /><br>
	<input type="submit" value="Sign In"/>
</form>
</div>
</body>
</html>