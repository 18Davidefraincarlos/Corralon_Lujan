package com.lujan;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lujan.modelos.Detalle;
import com.lujan.repositorios.RepoDetalle;
import com.lujan.servicios.ServicioDetalle;


@Service
public class ImpleDetalle implements ServicioDetalle {
	@Autowired
	private RepoDetalle repoDetalle;
	
	@Override
	public List<Detalle> Listar() {
	
		return repoDetalle.findAll();
	}
           
	@Override
	public Detalle Guardar(Detalle detalle) {
		
		return repoDetalle.save(detalle);
	}

	@Override
	public Detalle Buscar(Long id_detalle) {
	
		return repoDetalle.findById(id_detalle).get();
	}

	@Override
	public void Eliminar(Long id_detalle) {
		repoDetalle.deleteById(id_detalle);
		
	}

}
