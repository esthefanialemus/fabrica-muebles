select
c.id as id_cliente,
c.nombre as nombre_cliente,
c.apellido as apellido_cliente,
c.identificacion as identificacion_paciente,
c.email as email_paciente,
c.fechaCreacion as fecha_creacion_cliente,
co.id as id_compra,
co.total as total_compra,
co.fechaCompra as fechaDespacho,
co.fechaEntrega as fechaDespacho,
co.fechaDespacho as fechaDespacho

from cliente c
	inner join compra co on c.id = co.idCliente;

