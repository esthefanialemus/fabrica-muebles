CREATE TABLE usuario (
	id INT NOT NULL AUTO_INCREMENT,
	password varchar(100) NOT NULL,
	username varchar(100) NOT NULL,
    idRol INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (idRol) REFERENCES rol(id)
);

CREATE TABLE cliente (
	id INT NOT NULL AUTO_INCREMENT,
	nombre varchar(100) NOT NULL,
	apellido varchar(100) NOT NULL,
	identificacion varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	fecha_creacion datetime,
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
    idCliente INT NOT NULL,
    total DOUBLE NOT NULL,
    fechaCompra datetime,
    fechaDespacho datetime,
    fechaEntrega datetime,
	PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES cliente(id)
);

CREATE TABLE itemsCompra (
	id INT NOT NULL AUTO_INCREMENT,
    idCompra INT NOT NULL,
    idProducto INT NOT NULL,
    cantidad INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (idCompra) REFERENCES compra(id)
    FOREIGN KEY (idProducto) REFERENCES producto(id)
);