<%@page import="java.sql.ResultSet"%>
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
    <jsp:include page="_loggedmenu.jsp"></jsp:include>
 
    <ul>
    <%
        ResultSet rs = (ResultSet) session.getAttribute("results");
        if(rs != null){
            while(rs.next()){
                out.println("<li>");
                out.print("Id licitatie:"+ rs.getInt("id_licitatie") + "</br>");
                out.print("Increment minim:"+ rs.getInt("min_increment") + "</br>");
                out.print("Data:"+ rs.getDate("data_licitatie") + "</br>");
                out.print("Ora:"+ rs.getTime("ora") + "</br>");
                out.println("<a href = "+request.getContextPath()+"/licitatii?id="+rs.getInt("id_licitatie")+">");
                out.println("Detalii Licitatie");
                out.println("</a>");            
                out.println("</li>");
            }
        }
    %>
    </ul>
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>