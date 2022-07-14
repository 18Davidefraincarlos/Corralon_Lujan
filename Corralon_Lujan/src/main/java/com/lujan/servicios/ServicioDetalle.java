package com.lujan.servicios;

import java.util.List;

import com.lujan.modelos.Detalle;

public interface ServicioDetalle {

	   public List<Detalle> Listar();
	   public Detalle Guardar(Detalle detalle);
	   public Detalle Buscar (Long id_detalle);
	   public void Eliminar (Long id_detalle);
}
