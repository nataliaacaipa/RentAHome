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
        <div class="divForm">
            <form action="../../form-result.php" method="post" target="_blank">
            <p>

            Buscar casa: <input type="search" name="campobusqueda" list="listacasas">

            <input type="submit" value="Search"></p>

            </p>

            </form>

            <datalist id="listacasas">

            <option value="casa1">

            <option value="casa2">

            <option value="casa3">

            <option value="casa4">

            </datalist>
        </div>  


    </body>
</html>