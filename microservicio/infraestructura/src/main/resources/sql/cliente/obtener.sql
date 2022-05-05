select 
c.id ,
c.nombre ,
c.apellido ,
c.identificacion ,
c.email ,
c.fechaCreacion
from cliente as c
where id = :id;