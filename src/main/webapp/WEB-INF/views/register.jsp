<%@ page import = "com.immune.rentahouse.entity.User"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href=" css/style.css">
        <title>Rent a house</title>
    </head>
    <body>
        <%Boolean b = (Boolean) request.getAttribute("b");
        if(b){%>  
            <h1>Registro</h1>
            <div class="divForm">
                <form class="form" action = "/login" method="POST">
                    <p>Nombre</p>
                    <input type="text" required="required">
                    <p>Apellido</p>
                    <input type="text" required="required">
                    <p>Correo electrónico</p>
                    <input type="text" name="mail" required="required">
                    <p>Contraseña</p>
                    <input type="password" name="password" required="required">
                    <br>
                    <input  type="submit" value="Registrar">
                </form>
            </div>
        <%}else{%>

            <%Boolean okay = (Boolean) request.getAttribute("okay");
            if(okay){
            User newUser = (User) request.getAttribute("newUser"); 
            %>  
                <p></p>
                <p>Usuario agregado correctamente a la base de datos</p>
                <p></p>
                <button><a href="/index" class="boton" >ir a index</a></button> 

            <%}else{%> 
                <%String aviso = (String) request.getAttribute("aviso");%>
                <p><%=aviso%></p>
                <p></p>

            <%}%>
        <%}%>
    </body>
</html>