update compra
set idCliente = :idCliente,
	total = :total,
		fechaCompra = :fechaCompra,	
	fechaEntrega = :fechaEntrega,
	fechaDespacho = :fechaDespacho
where id = :id
