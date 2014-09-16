<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management</title>

<script type="text/javascript">


function ShowContent(id,firstName,lastName){
	$("#id").val(id);
	$("#firstName").val(firstName);
	$("#lastName").val(lastName);
	$("#action").val("Update");
}	
function isValid(){
	var firstName =$("#firstName").val();
	if(firstName==""){alert("Enter first name");return false;}
	
}
function refresh(){
	window.location = "user.html";
	
}
</script>
</head>
<body>
<h1>User Data</h1>
<form:form action="user.html" method="POST" commandName="user" id="userForm" onsubmit="return isValid();">
	<table>
		<tr>
			<td>User ID</td>
			<td><form:input path="id" id="id" readonly="true" /></td>
		</tr>
		<tr>
			<td>First name</td>
			<td><form:input path="firstName" id="firstName"/></td>
		</tr>
		<tr>
			<td colspan="2"><label id="firstName"></label></td>
			
		</tr>
		<tr>
			<td>Last name</td>
			<td><form:input path="lastName" id="lastName"/></td>
		</tr>
				<tr>
			<td colspan="2">
				<input type="submit" name="action" id="action" value="Add" />
				<input type="button" value="Refresh" onclick="refresh()"/>
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>First name</th>
	<th>Last name</th>
	
	<c:forEach items="${userList}" var="user">
		<tr>
			<td><a href="#" id="userId" onClick="ShowContent('${user.id}','${user.firstName}','${user.lastName}')" title="Click here to edit user details">${user.id}</a> </td>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>