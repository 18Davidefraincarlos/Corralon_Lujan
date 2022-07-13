package com.lujan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lujan.modelos.Empleado;
import com.lujan.repositorios.RepoEmpleado;
import com.lujan.servicios.ServicioEmpleado;


@Service
public class ImpleEmpleado implements ServicioEmpleado {
	@Autowired
	private RepoEmpleado repoEmpleado;
	
	@Override
	public List<Empleado> Listar() {
	
		return repoEmpleado.findAll();
	}
           
	@Override
	public Empleado Guardar(Empleado empleado) {
		
		return repoEmpleado.save(empleado);
	}

	@Override
	public Empleado Buscar(Long id_empleado) {
	
		return repoEmpleado.findById(id_empleado).get();
	}

	@Override
	public void Eliminar(Long id_empleado) {
		repoEmpleado.deleteById(id_empleado);
		
	}

}
