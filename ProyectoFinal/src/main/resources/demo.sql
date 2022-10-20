CREATE DATABASE PROYECTOFINAL;

USE PROYECTOFINAL;
CREATE TABLE clientes(
id INT PRIMARY KEY AUTO_INCREMENT,
dni VARCHAR(11) NOT NULL,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
fecha_nacimiento DATE
);

USE PROYECTOFINAL;
CREATE TABLE venta(
id INT PRIMARY KEY AUTO_INCREMENT,
fecha_alta DATE NOT NULL,
total DOUBLE,
cliente_id INT NOT NULL,
CONSTRAINT fk_cliente_id FOREIGN KEY(cliente_id) REFERENCES clientes(id)
);

USE PROYECTOFINAL;
CREATE TABLE detalle_venta(
id INT PRIMARY KEY AUTO_INCREMENT,
venta_id INT NOT NULL,
producto_id INT NOT NULL,
cantidad INT NOT NULL,
subtotal DOUBLE NOT NULL,
CONSTRAINT fk_venta_id FOREIGN KEY(venta_id) REFERENCES venta(id),
CONSTRAINT fk_producto_id FOREIGN KEY(producto_id) REFERENCES productos(id)
);

USE PROYECTOFINAL;
CREATE TABLE productos(
id INT PRIMARY KEY AUTO_INCREMENT,
sku VARCHAR(50),
descripcion VARCHAR(150),
precioCompra DOUBLE,
precioVenta DOUBLE,
stock INT,
fecha_alta DATE
);
