<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ page session="false" %>
<html>
<head>
<title>Spittle Details</title>
</head>
<div>
	<h1>Spittle Details</h1>
</div>
<body>
	<div>
		<a href="<c:url value="/homePage"/>">Go Back to HomePage</a><br>
	</div>
	<div>
		<c:out value="${spittle.message }"/>
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
	<div>
		<a href="<c:url value="/spittles"/>">Go to Spittle List</a><br>
	</div>
</body>
</html>