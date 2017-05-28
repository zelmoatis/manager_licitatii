<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Hello: ${user.userName}</h3>
 
    User Name: <b>${user.userName}</b>
    <br />
    Gender: ${user.gender } <br />
    <c:if test = "${user.admin}">
    	Administrator
    </c:if>
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>