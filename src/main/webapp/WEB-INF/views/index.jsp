<%@ page import = "com.immune.rentahouse.entity.User"%>
<%@ page import = "com.immune.rentahouse.entity.Lessee"%>
<%@ page import = "com.immune.rentahouse.service.LesseeService"%>
<%@ page import = "com.immune.rentahouse.repository.LesseeRepository"%>
<%@ page import = "com.immune.rentahouse.entity.Housing"%>
<%@ page import = "com.immune.rentahouse.service.HousingService"%>
<%@ page import = "com.immune.rentahouse.repository.HousingRepository"%>


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
        <%Boolean b = (Boolean) request.getAttribute("b");
        User user = (User) request.getAttribute("user");

        if(b){%> 
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

                    <input type="number" value="<%=user.getId()%>" name="id_user">

                    <input  type="submit" value="Añadir vivienda">
                </form>

            </div>

        <%}else{%>
            <%
            //Recupero los datos del usuario
            String username = (String) request.getAttribute("username");
            Lessee lessee = (Lessee) request.getAttribute("lessee");
            Housing housing = (Housing) request.getAttribute("housing");
            //LesseeService lesseeService = (LesseeService) request.getAttribute("lesseeService");
            //HousingService housingService = (HousingService) request.getAttribute("housingService");

            LesseeRepository lesseeRepository = (LesseeRepository) request.getAttribute("lesseeRepository");
            HousingRepository housingRepository = (HousingRepository) request.getAttribute("housingRepository");




            lessee.setName(user.getName());
            lessee.setLastname(user.getLastname());
            lessee.setMail(user.getMail());
            lessee.setPassword(user.getPassword());
            lessee.setId_user(user.getId());

            lesseeRepository.save(lessee);

            housing.setId_lessee(lessee.getId());

            housingRepository.save(housing);

        }%>

    </body>
</html>