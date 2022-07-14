package com.lujan;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lujan.modelos.Factura;
import com.lujan.repositorios.RepoFactura;
import com.lujan.servicios.ServicioFactura;


@Service
public class ImpleFactura implements ServicioFactura {
	@Autowired
	private RepoFactura repoFactura;
	
	@Override
	public List<Factura> Listar() {
	
		return repoFactura.findAll();
	}
           
	@Override
	public Factura Guardar(Factura factura) {
		
		return repoFactura.save(factura);
	}

	@Override
	public Factura Buscar(Long id_factura) {
	
		return repoFactura.findById(id_factura).get();
	}

/*	@Override
	public void Eliminar(Long id_factura) {
		repoFactura.deleteById(id_factura);
		
	}*/

}
