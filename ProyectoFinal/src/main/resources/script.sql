CREATE DATABASE PROYECTO_FINAL;

USE PROYECTO_FINAL;
CREATE TABLE clientes(
id INT PRIMARY KEY AUTO_INCREMENT,
dni VARCHAR(11) NOT NULL,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
fecha_nacimiento DATE
);

CREATE TABLE venta(
id INT PRIMARY KEY AUTO_INCREMENT,
fecha_alta DATE NOT NULL,
total DOUBLE,
cliente_id INT NOT NULL,
CONSTRAINT fk_cliente_id FOREIGN KEY(cliente_id) REFERENCES clientes(id)
);

CREATE TABLE productos(
id INT PRIMARY KEY AUTO_INCREMENT,
sku VARCHAR(50),
descripcion VARCHAR(150),
precioCompra DOUBLE,
precioVenta DOUBLE,
stock INT,
fecha_alta DATE
);

CREATE TABLE detalle_venta(
id INT PRIMARY KEY AUTO_INCREMENT,
venta_id INT NOT NULL,
producto_id INT NOT NULL,
cantidad INT NOT NULL,
subtotal DOUBLE NOT NULL,
CONSTRAINT fk_venta_id FOREIGN KEY(venta_id) REFERENCES venta(id),
CONSTRAINT fk_producto_id FOREIGN KEY(producto_id) REFERENCES productos(id)
);

INSERT INTO clientes 
(dni, nombre, apellido, fecha_nacimiento)
VALUES  ('30100001', 'Juan', 'Perez', '1980-01-10'),
		('30100102', 'Maria', 'Gomez', '1981-11-15'),
        ('35150801', 'Jose', 'Martinez', '1998-05-24'),
        ('39100001', 'Martina', 'Hernandez', '1999-06-28'),
        ('40100001', 'Josefina', 'Gonzalez', '2002-09-04');
        
INSERT INTO productos
(sku, descripcion, precioCompra, precioVenta, stock, fecha_alta)
VALUES	('AAA-123A01', 'PROD TIPO A', '110', '160', '100', '2022-09-01'),
		('ACD-125B11', 'PROD TIPO B', '540', '675', '10', '2022-09-11'),
        ('ABB-427C58', 'PROD TIPO C', '70', '100', '55', '2022-08-27'),
        ('CDE-986A60', 'PROD TIPO D', '15', '50', '1000', '2022-10-01'),
        ('CFY-653T07', 'PROD TIPO E', '450', '760', '5', '2022-09-01');
        
INSERT INTO venta
(fecha_alta, total, cliente_id)
VALUES	('2022-10-24', '32000', '1'),
		('2022-10-24', '1670', '4'),
        ('2022-10-25', '675', '1'),
        ('2022-10-25', '2885', '2'),
        ('2022-10-26', '1840', '3'),
        ('2022-10-26', '200', '5');
        
INSERT INTO detalle_venta
(venta_id, producto_id, cantidad, subtotal)
VALUES	('1', '1', '2', '32000'),
		('2', '4', '3', '150'),
        ('2', '5', '2', '1520'),
        ('3', '2', '1', '675'),
        ('4', '2', '3', '2025'),
        ('4', '3', '1', '100'),
        ('4', '5', '1', '760'),
        ('5', '1', '2', '320'),
        ('5', '5', '2', '1520'),
        ('6', '4', '4', '200');