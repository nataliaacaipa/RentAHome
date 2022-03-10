<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href=" css/style.css">
        <title>Rent a house</title>
    </head>
    <body>
        <h1>Iniciar sesión</h1>
        <div class="divLogin">
            <form class="form" action = "/login" method="POST">
                <p>Correo electrónico</p>
                <input type="text" name="mail" required="required">
                <p>Contraseña</p>
                <input type="password" name="password" required="required">
                <br>
                <input  type="submit" value="Iniciar sesión">
            </form>
        </div>

        <%
        if(request.getAttribute("respuesta")!=null){
            Boolean respuesta = (Boolean) request.getAttribute("respuesta");
            if(respuesta){
                %><p>Error, try again.</p><%
            }
        }
        %>
    </body>
</html>