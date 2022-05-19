select
     item.cantidad, prod.valor, prod.numeroPuesto, prod.tipoComedor, comp.total,comp.fechaCompra
from itemsCompra as item
    inner join compra as comp on (item.idCompra=comp.id)
    inner join producto as prod on (item.idProducto=prod.id)
where item.id=:id