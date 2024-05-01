<%@page import="conexion.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conexion.Conexion"%>

<%
    // Obtiene el parámetro de búsqueda enviado desde la página principal
    String busqueda = request.getParameter("busqueda");
    
    try {
        // Llama al método busqueda() para obtener los resultados de la búsqueda
        ArrayList<Cliente> clientes = Conexion.busqueda(busqueda);
        
        // Construye el HTML de la tabla con los resultados de la búsqueda
        StringBuilder tablaHTML = new StringBuilder();
        tablaHTML.append("<tr><th>Nombre</th><th>Primer Apellido</th><th>Segundo Apellido</th></tr>");
        for (Cliente cliente : clientes) {
            tablaHTML.append("<tr><td>").append(cliente.getNombre()).append("</td><td>")
                    .append(cliente.getPrimerApellido()).append("</td><td>")
                    .append(cliente.getSegundoApellido()).append("</td></tr>");
        }
        
        // Escribe el HTML de la tabla como respuesta a la solicitud AJAX
        out.println(tablaHTML.toString());
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
