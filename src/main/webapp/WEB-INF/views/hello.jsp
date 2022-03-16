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
        <%Boolean okay = (Boolean) request.getAttribute("okay");

        if(okay){%>  

        <div class="search" >
            <form action="/house" method="post" >
            <p>

            <input type="search" name="location" list="listacasas">

            <input type="submit" value="Search"></p>

            </form>
        </div>
        <%Iterable<Housing> houses = (Iterable<Housing>) request.getAttribute("houses");
        for(Housing house : houses){%>

                <datalist id="listacasas">

                <option value="<%=house.getLocation()%>">

                </datalist>


            <%}%> 

        <%}else{%>

            <div class="search" >
            <form action="/house" method="post" >
            <p>

            <input type="search" name="location" list="listacasas">

            <input type="submit" value="Search"></p>

            </form>
        </div>
        <%Iterable<Housing> houses = (Iterable<Housing>) request.getAttribute("houses");
        for(Housing house : houses){%>

                <datalist id="listacasas">

                <option value="<%=house.getLocation()%>">

                </datalist>


            <%}%> 

            <%Boolean b = (Boolean) request.getAttribute("b");
            if(b){
            String[] houseData = (String[]) request.getAttribute("houseData");
            String name = houseData[0];
            String phonenum = houseData[1];
            String location = houseData[2];
            String photo = houseData[3];%>

            <div class="todo">
                <div class="foto">
                    <img class="imagen" src="<%=photo%>"/>
                </div>

                <div class="info">
                    <div class="location" >
                        <h3><%=location%></h3>
                    </div>
                    <p></p>
                    <div class="name" >
                        <h3><%=name%></h3>
                    </div>
                    <p></p>
                    <div class="phonenum" >
                        <h3><%=phonenum%></h3>
                    </div>
                </div>
            <div>


            <%}else{%> 
                <p></p>
                <p>Error, inténtalo de nuevo.</p>
                <p></p>
            
            <%}%>
        <%}%>

    


    </body>
</html>