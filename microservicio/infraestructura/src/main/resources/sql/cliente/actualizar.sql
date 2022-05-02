update cliente
set
	nombre = :nombre,
		apellido = :apellido,
		identificacion = :identificacion,
		email = :email,
		fechaCreacion = :fechaCreacion
where id = :id	