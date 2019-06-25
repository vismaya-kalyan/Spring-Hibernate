<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
<style type="text/css">
	.error{color:red}
</style>
</head>
<body>
	<form:form action="processform" modelAttribute="student">
	
		FirstName: <form:input path="firstName"/> 
		<br><br>
		
		LastName: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		
		Age: <form:input path="age"/>
		<form:errors path="age" cssClass="error"/>
		<br><br>
			
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br><br>
		
		Postal Code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		
		Favorite Programming Language:
		<br>
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		C <form:radiobutton path="favoriteLanguage" value="C"/>
		<br><br>
		
		Operating Systems:
		<br>
		Linux <form:checkbox path="operatingSystem" value="Linux"/>
		Windows <form:checkbox path="operatingSystem" value="Windows"/>
		Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
		<br><br>
		Course Code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		<br><br>
		<br><br>
		<input type="submit" value="Submit"/>
		
	
	</form:form>
</body>
</html>
