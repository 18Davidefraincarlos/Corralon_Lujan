package com.lujan;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lujan.modelos.Usuario;
import com.lujan.repositorios.RepoUsuario;
import com.lujan.servicios.ServicioUsuario;


@Service
public class ImpleUsuario implements ServicioUsuario {
	@Autowired
	private RepoUsuario repoUsuario;
  //MOSTRAR LOS USUARIOS
	@Override
	public List<Usuario> Listar() {
	
		return repoUsuario.findAll();
	}
  //GUARDAR UN USUARIO       
	@Override
	public Usuario Guardar(Usuario usuario) {
		
		return repoUsuario.save(usuario);
	}
  //BUSCAR UN USUARIO
	@Override
	public Usuario Buscar(Long id_usuario) {
	
		return repoUsuario.findById(id_usuario).get();
	}
  //BORRAR UN USUARIO
	@Override
	public void Eliminar(Long id_usuario) {
		repoUsuario.deleteById(id_usuario);
		
	}

}

