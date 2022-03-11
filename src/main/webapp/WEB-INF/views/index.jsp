<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href=" css/style.css">
        <title>Rent a house</title>
    </head>
    <body>
        <h2>:) has entrao</h2>
        <%
        //Recupero los datos del usuario

        String username = (String) request.getAttribute("username");%>
        <p><%=username%></p>

    </body>
</html>