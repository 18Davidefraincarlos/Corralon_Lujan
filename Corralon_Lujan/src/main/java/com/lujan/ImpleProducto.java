package com.lujan;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lujan.modelos.Producto;
import com.lujan.repositorios.RepoProducto;
import com.lujan.servicios.ServicioProducto;


@Service
public class ImpleProducto implements ServicioProducto {
	@Autowired
	private RepoProducto repoProducto;
	
	@Override
	public List<Producto> Listar() {
	
		return repoProducto.findAll();
	}
           
	@Override
	public Producto Guardar(Producto producto) {
		
		return repoProducto.save(producto);
	}

	@Override
	public Producto Buscar(Long id_producto) {
	
		return repoProducto.findById(id_producto).get();
	}

	@Override
	public void Eliminar(Long id_producto) {
		repoProducto.deleteById(id_producto);
		
	}

}
