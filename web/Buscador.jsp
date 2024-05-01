<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conexion.Conexion"%>  

<!DOCTYPE html>
<html>
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
