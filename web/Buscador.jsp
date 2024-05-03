<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conexion.Conexion"%>  

<!DOCTYPE html>
<html>
    <style>
        body {
            text-align: center;
        }
        
        h1{
            margin-left: 25%;
        }

        div { 
            margin: 0 auto;
            width: 50%;
            text-align: left;
        }

        input[type="text"] {
            margin: 10px auto;
            width: 25%;
            height: 20px;
            display: block;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 30%;
     
        }

        th, td {
            padding: 5px;

        }

        th {
            background-color: #f2f2f2
        }

    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <div>
            <h1>Pegadero de la Mula</h1>
        </div>
        <input type="text" id="inputBusqueda" placeholder="Buscar..." onkeyup="buscarClientes()">
        <table id="tablaResultados">
            <!-- La tabla se actualizará dinámicamente aquí -->
        </table>

       <script>
    function buscarClientes() {
        var inputBusqueda = document.getElementById("inputBusqueda").value;
        var tabla = document.getElementById("tablaResultados");
        
        // Ocultar la tabla si el campo de búsqueda está vacío
        if (inputBusqueda.trim() === "") {
            tabla.style.display = "none";
            return; // No es necesario realizar la solicitud AJAX
        } else {
            tabla.style.display = "block"; // Mostrar la tabla
        }

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                tabla.innerHTML = xhr.responseText;
            }
        };
        xhr.open("GET", "BuscarClientes.jsp?busqueda=" + inputBusqueda, true);
        xhr.send();
    }
</script>

    </body>
</html>