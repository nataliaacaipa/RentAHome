<%@ page import = "com.immune.rentahouse.entity.Housing"%>

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
        <div class="search" >
            <form action="/house" method="post" >
            <p>

            <input type="search" name="location" list="listacasas">

            <input type="submit" value="Search"></p>

            </form>

            <%Iterable<Housing> houses = (Iterable<Housing>) request.getAttribute("houses"); 
            String[] houseData = (String[]) request.getAttribute("houseData");
            %>

            <%for(Housing house : houses){%>

            <datalist id="listacasas">

            <option value="<%=house.getLocation()%>">

            <%}%>

            </datalist>
        </div>  

        <div>
            
        </div>

         <button onclick="window.location.href='/'">ir a inicio</button> 

    </body>
</html>