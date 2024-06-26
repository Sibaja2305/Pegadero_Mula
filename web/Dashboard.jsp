<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                display: flex;
                height: 100vh;
            }
            .header {
                background: #4CAF50;
                color: #fff;
                padding: 15px;
                text-align: center;
            }
            .container{
                margin-bottom: 20px;
                padding: 20px;
                margin-left:15%;

            }
            .button-group {
                margin-top: 20px;
            }
            .button {
                padding: 10px 20px;
                margin-right: 10px;
                background: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 200px;
                height: 100px;
                margin-bottom: 10px;
            }
            .button:hover {
                background: #45a049;
            }
            .btnEscenario{
                padding: 10px 20px;
                margin-right: 10px;
                background: #603BDB;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 200px;
                height: 100px;
                margin-bottom: 10px;
            }
            .btnEscenario:hover {
                background: #793BDB;
            }
        </style>
    </head>
    <body>

        <div class="main-content">
            <header class="header">
                <h1>Dashboard</h1>
            </header>

            <div class="container">
                <h2>Secciones</h2>
                <div class="button-group">
                    <button onclick="location.href = 'Pedido.jsp'" class="btnEscenario" >Escenario</button>
                    <button onclick="location.href = 'Bonificaciones.jsp'" class="button">Bonificaciones</button>
                    <button onclick="location.href = 'Caja.jsp'" class="button">Caja</button>
                    <button onclick="location.href = 'Canton.jsp'" class="button">Canton</button>
                    <button onclick="location.href = 'Cliente.jsp'" class="button">Cliente</button>
                    <button onclick="location.href = 'ClientesSucursales.jsp'" class="button">Cliente Sucursal</button>
                    <button onclick="location.href = 'Combo.jsp'" class="button">Combo</button>
                    <button onclick="location.href = 'ComboProducto.jsp'" class="button">Combo Producto</button>
                    <button onclick="location.href = 'DireccionFisica.jsp'" class="button">Direccion Fisica</button>
                    <button onclick="location.href = 'Distrito.jsp'" class="button">Distrito</button>
                    <button onclick="location.href = 'Empleados.jsp'" class="button">Empleados</button>
                    <button onclick="location.href = 'EstadoPago.jsp'" class="button">Estado Pago</button>
                    <button onclick="location.href = 'Express.jsp'" class="button">Express</button>
                    <button onclick="location.href = 'HorasExtras.jsp'" class="button">Horas Extra</button>
                    <button onclick="location.href = 'Impuesto.jsp'" class="button">Impuesto</button>
                    <button onclick="location.href = 'Ingredientes.jsp'" class="button">Ingredientes</button>
                    <button onclick="location.href = 'Mesa.jsp'" class="button">Mesa</button>
                    <button onclick="location.href = 'MetodoPago.jsp'" class="button">Metodo Pago</button>
                    <button onclick="location.href = 'PagoEmpleado.jsp'" class="button">Pago Empleado</button>
                    <button onclick="location.href = 'PagoProveedor.jsp'" class="button">Pago Proveedor</button>
                    <button onclick="location.href = 'PagoServicios.jsp'" class="button">Pago Servicios</button>
                    <button onclick="location.href = 'Producto.jsp'" class="button">Producto</button>
                    <button onclick="location.href = 'ProductoIngrediente.jsp'" class="button">Producto Ingrediente</button>
                    <button onclick="location.href = 'Proveedores.jsp'" class="button">Proveedores</button>
                    <button onclick="location.href = 'Provincia.jsp'" class="button">Provincia</button>
                    <button onclick="location.href = 'RolesEmpleados.jsp'" class="button">Roles Empleados</button>
                    <button onclick="location.href = 'Servicios.jsp'" class="button">Servicios</button>
                    <button onclick="location.href = 'Sucursal.jsp'" class="button">Sucursal</button> 
                    <button onclick="location.href = 'TipoProducto.jsp'" class="button">Tipo Producto</button>
                    <button onclick="location.href = 'UnidadesMedida.jsp'" class="button">UnidadesMedida</button>
                    <button onclick="location.href = 'Vacaciones.jsp'" class="button">Vacaciones</button>
                    <button onclick="location.href = 'Factura.jsp'" class="button">Factura</button>
                     <button onclick="location.href = 'Escenario1.jsp'" class="button">Escenario 1</button>
                      <button onclick="location.href = 'Escenario2.jsp'" class="button">Escenario 2</button>
                      <button onclick="location.href = 'Escenario3.jsp'" class="button">Escenario 3</button>
                      <button onclick="location.href = 'Escenario4.jsp'" class="button">Escenario 4</button>
                      <button onclick="location.href = 'Escenario5.jsp'" class="button">Escenario 5</button>
                      <button onclick="location.href = 'Escenario6.jsp'" class="button">Escenario 6</button>
                      <button onclick="location.href = 'Escenario7.jsp'" class="button">Escenario 7</button>
                      <button onclick="location.href = 'Escenario8.jsp'" class="button">Escenario 8</button>

                </div>
            </div>


    </body>
</html>
