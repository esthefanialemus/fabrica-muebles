select
     item.cantidad, prod.valor, prod.numeroPuesto, prod.tipoComedor
from itemsCompra as item

    inner join producto as prod on (item.idProducto=prod.id)
where  item.idCompra  is null