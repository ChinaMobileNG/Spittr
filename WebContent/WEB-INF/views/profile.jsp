<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Personal profile</title>
<link rel="stylesheet" type="text/css" href="/resources/styles/customize.css"/>
</head>
<body>
<h1>Profile</h1>
<span>Hello, ${spitter.lastName} ${spitter.firstName} !!</span>
<a href="<c:url value="/"/>" class="greycolor">write a spittle now</a>
</body>
</html>