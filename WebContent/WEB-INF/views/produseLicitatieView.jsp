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
    <p>Min Increment:
        ${min}
    </p>
    <ul>
    <%
        ResultSet rs = (ResultSet) session.getAttribute("prodResults");
        if(rs != null){
            while(rs.next()){
                out.println("<li>");
                out.print("Id produs:"+ rs.getInt("id_produs") + "</br>");
                out.print("Nume:"+ rs.getString("nume") + "</br>");
                out.print("Pret Curent:"+ rs.getInt("pret_pornire") + "</br>");
                out.print("Nume Vanzator:"+ rs.getString("nume_vanzator") + "</br>");
                out.print("<img src=\""+ rs.getString("poza")+ "\" alt = \"default.png\">" + "</br>");
                out.println("</li>");
            }
        }
    %>
    
    <div>
        Participa la licitatie. Introdu valoare mai mare sau egala cu (Pretul Curent * Incrementul Minim).
        <p style="color: red;">${errorString}</p>
 
        <form method="POST" action="doBid">
            Pret de participare:
            <input type="text" name="bidValue"/>
            <br/>
            Id Produs:
            <input type="text" name="idProdus"/>   
            <br/> 
            <c:if test = "${user.admin}">
            Id bidder:
            <input type="text" name="idBidder"/>   
            <br/> 
            </c:if>
            <input type="submit" value= "Submit" />
            <a href="${pageContext.request.contextPath}/">Cancel</a>
            
        </form>

    </div>
    </ul>
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>