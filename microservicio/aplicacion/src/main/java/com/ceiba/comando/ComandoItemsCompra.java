package com.ceiba.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoItemsCompra {

    private Long id;
    private Long cantidad;
	private Long idCompra;
    private Long idProducto;

}
