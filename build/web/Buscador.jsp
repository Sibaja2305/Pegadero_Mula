<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <style>
            body {
                text-align: center;
                background-color: #284022;
            }
            img{
                width: 120px;
                height: 100px;
                border-radius: 10px;
            }

            .container {
                margin: 0 auto;
                width: 300px;
                background-color: ghostwhite;
                border-radius: 10px;
                padding: 20px;
            }

            input[type="text"] {
                margin: 10px auto;
                width: 70%;
                height: 20px;
                display: block;
            }

            table {
                margin: 0 auto;
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <img src="logo.jpg" alt=""/>
            <h1>Pegadero de la Mula</h1>
            <input type="text" id="inputBusqueda" placeholder="Buscar..." onkeyup="buscarClientes()">
            <table id="tablaResultados">
                <!-- La tabla se actualizará dinámicamente aquí -->
            </table>
        </div>

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
                xhr.onreadystatechange = function () {
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