<%@ page import = "com.immune.rentahouse.entity.User"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href=" css/style.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="scripts.js"></script>
        <title>Rent a house</title>
    </head>
    <body>
        <h2>:) has entrao</h2>
        <%
        //Recupero los datos del usuario
        String username = (String) request.getAttribute("username");
        User user = (User) request.getAttribute("user");
        %>
        <p><%=username%></p>
        <p><%=user.getId()%></p>


        <p>Datos a rellenar</p>
        <div class="divForm">
            <form class="form" action = "/housing" method="POST">
                <p>Número de teléfono</p>
                <input type="tel" name="phonenum" pattern="[0-9]{9}" required="required">
                <p>Ubicación</p>
                <input type="text" name="location" required="required">
                <p>Foto</p>
                <input type="text" name="photo" required="required">
                <br>

                <input type="number" value="<%=user.getId()%>" name="id">

                <input  type="submit" value="Añadir vivienda">
            </form>

        </div>

    </body>
</html>