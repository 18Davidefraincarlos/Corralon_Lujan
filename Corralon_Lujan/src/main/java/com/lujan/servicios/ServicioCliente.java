package com.lujan.servicios;

import java.util.List;

import com.lujan.modelos.Cliente;

public interface ServicioCliente {

	   public List<Cliente> Listar();
	   public Cliente Guardar(Cliente cliente);
	   public Cliente Buscar (Long id_cliente);
	   public void Eliminar (Long id_cliente);
}
