<%@page import="Clases.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="conexion.Conexion"%>
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
                width: 500px;
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
            <%

                Conexion sql = new Conexion();
                String cedula = request.getParameter("cedula");
                ArrayList<Persona> list = new ArrayList<Persona>();
                if (cedula != null) {
                    list = sql.busquedaCedula(cedula);
                } else {
                    cedula = "";

                }

            %>
            <form action="BuscarCedula.jsp" method="Post">
                <input  type="text" id="cedula" name="cedula" placeholder="Buscar..." ">
                <input type="submit" value="Buscar" />
            </form>
            <table id="tablaResultados">
                <thead>
                    <tr>

                        <th class="text-center">Cedula</th>
                        <th class="text-center" >Nombre</th>
                        <th class="text-center">Primer Apellido</th>
                        <th class="text-center">Segundo Apellido </th>


                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getC_Cedula()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getD_Nombre()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getD_Primer_Apellido()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getD_Segundo_Apellido()%></td>
                        <td class="text-center">
                            <form action="NewCliente.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="number" 
                                    name="seleccionado" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Persona() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Seleccionar" >
                                
                            </form>
                            <%
                                }
                            %>      
            </table>
        </div>

    </body>
</html>
