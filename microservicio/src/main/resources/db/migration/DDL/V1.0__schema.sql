create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);
create table roles_carrion (
 id int (11) not null auto_increment,
 nombre_rol varchar (50) not null,
 primary key (id)
);

create table usuario_carrion (
 id int(11) not null auto_increment,
 identificacion int(15),
 nombre varchar(100) not null,
 apellido varchar(45) not null,
 edad int (10) null,
 tipo_rol int (10),
 ciudad_residencia varchar (50) null,
 correo_electronico varchar (50) null,
 fecha_creacion datetime default now(),
 usuario varchar (50) not null,
 clave varchar (50) not null,
 primary key (id),
 CONSTRAINT FK_Tipo_Rol FOREIGN KEY (tipo_rol) REFERENCES roles_carrion (id)

);

create table tipo_vehiculo_carrion (
 id int (11) not null auto_increment,
 nombre_tipo_vehiculo varchar (50) not null,
 primary key (id)
);


create table vehiculo_carrion (
 id int(11) not null auto_increment,
 id_conductor int(15),
 placa varchar (10) not null,
 numero_motor varchar (50) not null,
 numero_chasis varchar (50) not null,
 toneladas int (10) not null,
 tipo_vehiculo int (10) not null,
 modelo int (20),
 marca varchar (50),
 primary key (id),
 CONSTRAINT FK_Tipo_Vehiculo FOREIGN KEY (tipo_vehiculo) REFERENCES tipo_vehiculo_carrion (id),
 CONSTRAINT FK_Id_Conductor FOREIGN KEY (id_conductor) REFERENCES usuario_carrion (id)
);

create table viajes_carrion (
 id int (11) not null auto_increment,
 id_usuario int (11),
 id_conductor int (15),
 toneladas int (20),
 tipo_vehiculo int (10) not null,
 fecha_creacion datetime default now(),
 fecha_servicio datetime not null,
 origen varchar (50),
 destino  varchar (50),
 terminado boolean default false,
 tipo_casa varchar (50),
 precio int (50),
 primary key (id),
 CONSTRAINT FK_Id_Conductor_Viajes FOREIGN KEY (id_conductor) REFERENCES vehiculo_carrion (id)
);





