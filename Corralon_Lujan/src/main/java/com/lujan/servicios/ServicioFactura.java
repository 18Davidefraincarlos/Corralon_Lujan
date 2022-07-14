package com.lujan.servicios;

import java.util.List;

import com.lujan.modelos.Factura;

public interface ServicioFactura {

	   public List<Factura> Listar();
	   public Factura Guardar(Factura factura);
	   public Factura Buscar (Long id_factura);
	  // public void Eliminar (Long id_factura);
}
