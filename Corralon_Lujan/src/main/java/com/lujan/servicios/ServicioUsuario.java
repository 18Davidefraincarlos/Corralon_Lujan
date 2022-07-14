package com.lujan.servicios;

import java.util.List;

import com.lujan.modelos.Usuario;

public interface ServicioUsuario {

	   public List<Usuario> Listar();
	   public Usuario Guardar(Usuario usuario);
	   public Usuario Buscar (Long id_usuario);
	   public void Eliminar (Long id_usuario);
}
