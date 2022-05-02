select 
c.id as id_cliente,
c.nombre as nombres_cliente,
c.apellido as apellidos_cliente,
c.identificacion as identificacion_paciente,
c.email as email_paciente,
c.fechaCreacion as fecha_creacion_cliente
from cliente c
where id = :id