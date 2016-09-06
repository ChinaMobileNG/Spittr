<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t"  uri="http://tiles.apache.org/tags-tiles"%>
<%@ page session="false" %>
<html>
<head>
<title>Spittr</title>
<link type="text/css" rel="stylesheet" href="<s:url value="/resources/styles/customize.css" />"/>
</head>
<body class="center magntp100 greybkgd">
<div id="header">
	<t:insertAttribute name="header"></t:insertAttribute>
</div>

<div id="content" class="center">
	<t:insertAttribute name="body"></t:insertAttribute>
</div>

<div id="footer">
	<t:insertAttribute name="footer"></t:insertAttribute>
</div>
</body>
</html>