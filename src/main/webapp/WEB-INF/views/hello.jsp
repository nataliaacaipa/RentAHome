<%@ page import = "com.immune.rentahouse.entity.Housing"%>
<%@ page import = "com.immune.rentahouse.entity.Lessee"%>
<%@ page import = "com.immune.rentahouse.entity.User"%>

<%@ page import = "com.immune.rentahouse.service.LesseeService"%>



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
        <%Boolean okay = (Boolean) request.getAttribute("okay");
        User user = (User) request.getAttribute("user");
        if(okay){%>  

         <div >
            <form class="boton" action = "/houseform" method="POST">
                <input  type="submit" value="Añadir casa">
            </form>

        </div>

        <%Iterable<Housing> houses = (Iterable<Housing>) request.getAttribute("houses");
        Iterable<Lessee> lessees = (Iterable<Lessee>) request.getAttribute("lessees");
        LesseeService lesseeService = (LesseeService) request.getAttribute("lesseeService");
        for(Housing house : houses){%>

                    <datalist id="listacasas">

                    <option value="<%=house.getLocation()%>">

                    </datalist>

                <div class="todoInicio" >
                    <div  >
                    <p></p>

                        <img class="imagenInicio" src="<%=house.getPhoto()%>"/>
                     <p></p>

                    </div>

                    <div class="infoInicio" >
                        <div  >
                            <h3><%=house.getLocation()%></h3>
                        </div>
                        <p></p>
                        <div  >
                            <h3><%=lesseeService.getNameLastName(house.getId_lessee())%></h3>
                        </div>
                        <p></p>
                        <div  >
                            <h3><%=lesseeService.getPhoneNum(house.getId_lessee())%></h3>
                        </div>
                    </div>
                </div>

        <%}%> 

        
        

        <%}else{%>
                <p></p>
                <p>Error, inténtalo de nuevo.</p>
                <p></p>
            
            <%}%>

    


    </body>
</html>