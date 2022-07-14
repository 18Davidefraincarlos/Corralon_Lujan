package com.lujan.servicios;

import java.util.List;

import com.lujan.modelos.Producto;

public interface ServicioProducto {

	   public List<Producto> Listar();
	   public Producto Guardar(Producto producto);
	   public Producto Buscar (Long id_producto);
	   public void Eliminar (Long id_producto);
}
