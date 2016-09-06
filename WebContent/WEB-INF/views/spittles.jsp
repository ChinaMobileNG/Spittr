<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ page session="false" %>
<html>
<head>
<title>Spittles</title>
</head>
<body>
<h1>Happy looking</h1>
<div>
<br>
<c:forEach items="${spittleList}" var="spittle">
<div>
	<li id="spittle_<c:out value="${spittle.id}"/>">
		<div>
			<c:out value="${spittle.message }"/>
			<a href="<c:url value="/spittles/${spittle.id}"/>">Details</a>
		</div>	
		<div>
			<span>
			<c:out value="${spittle.time }" />
			</span><br>
			<span>
				latitude:<fmt:formatNumber value="${spittle.latitude}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>  
			</span>,
			<span>
				longtitude:<fmt:formatNumber value="${spittle.longtitude}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber> 
			</span>  
		</div>
	</li>
</div>
</c:forEach>
</div>
</body>
</html>