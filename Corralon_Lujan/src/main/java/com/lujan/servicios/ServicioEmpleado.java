package com.lujan.servicios;

import java.util.List;

import com.lujan.modelos.Empleado;

public interface ServicioEmpleado{

	   public List<Empleado> Listar();
	   public Empleado Guardar(Empleado empleado);
	   public Empleado Buscar (Long id_empleado);
	   public void Eliminar (Long id_empleado);
}