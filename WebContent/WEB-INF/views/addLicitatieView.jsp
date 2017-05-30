
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Licitatie</title>
</head>
<body>
    

     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_loggedmenu.jsp"></jsp:include>

    Adaugati Licitatie:
    <form action="doAddLicitatie" method="post">
        Increment minim: <input type="text" name="min_increment">
        <br/>
        Data licitatie(dd-mm-yyyy) <input type="text" name="data_licitatie">
        <br/>
        Ora: <input type="text" name="ora">
        <br/>
        <input type="submit" name="submit">
    </form>

    <p>${succesString}</p>
    <p>${errorString}</p>
      <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
