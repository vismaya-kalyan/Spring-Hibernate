<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

Student ${student.firstName} ${student.lastName} is confirmed.
<br>
Age: ${student.age}
<br>
Location: ${student.country}
<br>
Postal Code: ${student.postalCode}
<br>
Favorite Language: ${student.favoriteLanguage}
<br>
Operating Systems: 
<ul>
<c:forEach var="temp" items="${student.operatingSystem}">
	<li> ${temp} </li>
</c:forEach>
</ul>

</body>
</html>