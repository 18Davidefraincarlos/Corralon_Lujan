package com.lujan;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lujan.modelos.Cliente;
import com.lujan.repositorios.RepoCliente;
import com.lujan.servicios.ServicioCliente;


@Service
public class ImpleCliente implements ServicioCliente {
	@Autowired
	private RepoCliente repoCliente;
	
	@Override
	public List<Cliente> Listar() {
	
		return repoCliente.findAll();
	}
           
	@Override
	public Cliente Guardar(Cliente cliente) {
		
		return repoCliente.save(cliente);
	}

	@Override
	public Cliente Buscar(Long id_cliente) {
	
		return repoCliente.findById(id_cliente).get();
	}

	@Override
	public void Eliminar(Long id_cliente) {
		repoCliente.deleteById(id_cliente);
		
	}

}
