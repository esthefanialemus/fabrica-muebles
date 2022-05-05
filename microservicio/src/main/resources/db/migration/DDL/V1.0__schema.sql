CREATE TABLE usuario (
	id INT NOT NULL AUTO_INCREMENT,
	clave varchar(100) NOT NULL,
	nombre varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE cliente (
	id INT NOT NULL AUTO_INCREMENT,
	nombre varchar(100) NOT NULL,
	apellido varchar(100) NOT NULL,
	identificacion varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	fechaCreacion datetime,
	PRIMARY KEY (id)
);
CREATE TABLE producto (
	id INT NOT NULL AUTO_INCREMENT,
	valor DOUBLE NOT NULL,
	numeroPuesto varchar(100) NOT NULL,
	tipoComedor varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE compra (
	id INT NOT NULL AUTO_INCREMENT,
    idCliente INT ,
    total DOUBLE NOT NULL,
    fechaCompra datetime,
    fechaDespacho datetime,
    fechaEntrega datetime,
	PRIMARY KEY (id),
    CONSTRAINT FK_id_cliente FOREIGN KEY (idCliente) REFERENCES cliente (id)
);

CREATE TABLE itemsCompra (
	id INT NOT NULL AUTO_INCREMENT ,
    idCompra INT ,
    idProducto INT ,
    cantidad INT NOT NULL,
	PRIMARY KEY (id),
CONSTRAINT FK_id_compra FOREIGN KEY (idCompra) REFERENCES compra (id),
CONSTRAINT FK_id_producto FOREIGN KEY (idProducto) REFERENCES producto (id)
);