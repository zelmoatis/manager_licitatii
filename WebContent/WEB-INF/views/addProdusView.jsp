
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Produs</title>
</head>
<body>
    

     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_loggedmenu.jsp"></jsp:include>

    Adaugati produsele:
    <form action="doAddProdus" method="post">
        Nume produs: <input type="text" name="nume">
        <br/>
        Pretul de pornire: <input type="text" name="pret_pornire">
        <br/>
        Numele vanzatorului: <input type="text" name="nume_vanzator">
        <br/>
        Calea catre poza: <input type="text" name="poza">
        <br/>
        Id licitatie : <input type="text" name="id_licitatie">
        <br/>
        <input type="submit" name="submit">
    </form>

    <p>${succesString}</p>
    <p>${errorString}</p>
      <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
