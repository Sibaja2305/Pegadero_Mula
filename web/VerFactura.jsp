<%-- 
    Document   : VerFactura
    Created on : 02/06/2024, 06:40:54 PM
    Author     : user
--%>

<%@page import="Clases.DetallePedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.VerFactura"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            display: flex;
            text-align: center;
            justify-content: center;
            align-content: center;
        }
        .container{

            border-radius:10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 1);
            padding: 15px;
        }
        .sucursalContainer{
            text-align: left;
            border-bottom: 2px dotted black;
        }
        .infBilling{
            text-align: left;
            border-bottom: 2px dotted black;
        }
        .orderContainer{
            justify-content:space-around;
            border-bottom: 2px dotted black;
        }
        .orderContent{
            display: flex;
            justify-content: space-between;
        }
        .taxContainer{
            display: flex;
            justify-content:space-around;
            border-bottom: 2px dotted black;
        }
        button{
            width: 100px;
            height: 50px;
            background-color: blue;
            border-radius: 15px;
            color:white;
            margin-top: 10px;
            border: none;
            cursor: pointer;
        }

        button:hover{
            background-color: #0c63e4;
        }


    </style>
    <body>
        <div>
            <div class="container">
                <div>
                    <h1>Factura</h1>
                </div>
                <%
                    Conexion sql = new Conexion();
                    int codigoFactura = Integer.parseInt(request.getParameter("codigoFactura"));
                    ArrayList<VerFactura> list = sql.obtenerDatosFacturas(codigoFactura);
                %>

                <%--Informacion de Sucursal--%>
                <div>
                    <p>
                        <%=list.get(0).getDireccionFisica()%>
                    </p>  
                    <p>
                        <%=list.get(0).getSucursal()%>
                    </p> 
                    <div class="sucursalContainer">

                        <p>Telefono: <%=list.get(0).getTelefono()%></p>  

                        <p>    <%=list.get(0).getCorreoElectronico()%><p>  
                    </div>
                </div>

                <%--Informacion de Factura--%>
                <div class="infBilling">
                    <p>Codigo Factura: <%=list.get(0).getCodigoFactura()%></p>
                    <p>Fecha Factura: <%=list.get(0).getFechaFactura()%></p>
                    <p>Nombre Empleado: <%=list.get(0).getNombreCompleto()%></p>
                    <p>Codigo pedido: <%=list.get(0).getCodigoPedido()%></p>
                </div>

                <%--Informacion de Pedidos--%>
                <div class="orderContainer">
                    <%
                        ArrayList<DetallePedido> listPedidos = sql.seleccionarDetallesPedido(list.get(0).getCodigoPedido());

                        for (DetallePedido pedido : listPedidos) {
                    %>
                    <div class="orderContent">
                        <p><%= pedido.getCantidadProducto()%></p>
                        <p><%= pedido.getNombreProducto()%></p>
                        <p><%= pedido.getMontoTotal()%></p>  
                    </div>
                    <%
                        }
                    %>
                </div>



                <%--Informacion de Impuesto--%>
                <div class="taxContainer">
                    <p> <%=list.get(0).getTipoImpuesto()%></p>
                    <p> <%=list.get(0).getImpuesto()%></p>
                </div>
                <%--Total Factura--%>
                <div>
                    <h2>Total: <%=list.get(0).getTotal()%></h2>
                </div>
            </div>
            <div>
                <a href="Dashboard.jsp">
                    <button>Finalizar</button>
                </a>
            </div>
        </div>
    </body>
</html>
