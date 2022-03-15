<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href=" css/style.css">
        <title>Rent a home</title>
    </head>
    <body>
        <h1>Iniciar sesión</h1>
        <div class="divForm">
            <form class="form" action = "/index" method="POST">
                <p>Correo electrónico</p>
                <input type="email" name="mail" required="required">
                <p>Contraseña</p>
                <input type="password" name="password" required="required">
                <br>
                <input  type="submit" value="Iniciar sesión">
            </form>

        </div>
        <div  id="register">
         <button onclick="window.location.href='/register'">Registrate</button> 
        </div>

        <%
        if(request.getAttribute("respuesta")!=null){
            Boolean respuesta = (Boolean) request.getAttribute("respuesta");
            if(respuesta){
                %><p>Error, inténtalo de nuevo.</p><%
            }
        }
        %>
    </body>
</html>