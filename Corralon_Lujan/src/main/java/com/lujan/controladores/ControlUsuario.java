package com.lujan.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lujan.modelos.Usuario;

import com.lujan.servicios.ServicioUsuario;


@Controller
public class ControlUsuario {
	
	
	//********** LOGIN *************
	 	@GetMapping
	 	public String login(Model modelo) {
	 		Usuario usuario = new Usuario();
	 		modelo.addAttribute("usuario",usuario);
		 return "index";
	    }
	    @GetMapping("/index")
	 	public String index(Model modelo) {
	 		Usuario usuario = new Usuario();
	 		modelo.addAttribute("usuario",usuario);
		 return "index";
	    }
	//********** VALIDAR *************
	 	@PostMapping("/login")
	    public String validarUsuario(@ModelAttribute Usuario usuario, Model modelo) {
	 		
	 		for (Usuario user: servicioUsuario.Listar()) {
				if(user.getNombre().compareTo(usuario.getNombre())==0 && user.getPassword().compareTo(usuario.getPassword())== 0 ) {
					
					return "inicio";
				}
	 	     }
			usuario=null;
	 		modelo.addAttribute("usuario",usuario);
	 	 return "redirect:/index";
	 	}
	 	//********INICIO DE LA APLICACION**********
	    @GetMapping("/inicio")
	  	public String index() {

	 	 return "inicio";
	    }
	    
		//Instanciar Servicio  de ServicioUsuario para poder utilizar los servicios 
		 	@Autowired
		 	private ServicioUsuario servicioUsuario;
		
		//********** LISTAR y AGREGAR UN NUEVO  Usuario *************
		 	
		 	@GetMapping("/Usuario")
		 	public String Usuario(Model modelo) {
				modelo.addAttribute("Usuario",servicioUsuario.Listar());
				/*Para un nuevo Usuario*/
				Usuario usuario = new Usuario();
			    modelo.addAttribute("newUsuario",usuario);
			  
			  return "Usuario";
		    }
		 	
		//********* GUARDAR ******************
		
		 	@PostMapping("/saveUsuario")
		    public String saveUsuario(@ModelAttribute Usuario usuario) {
		 		servicioUsuario.Guardar(usuario);
		 	  
		 	  return "redirect:/Usuario";//vuelve a listar Usuarios con el nuevo añadido
		 	}
		 	
		 //********* EDITAR ******************
		 	@GetMapping("/editUsuario/{id}")
		 	public String editProducto(@PathVariable("id") Long id_usuario, Model modelo) {
		 		//busca el Usuario por Id 
		 		Usuario editUsuario = servicioUsuario.Buscar(id_usuario);
		 		 //pasar a html
		         modelo.addAttribute("editUsuario",editUsuario);
		 	 return "modifUsuario";/*llamo a otra pagina*/
		 		 
		 	}
		
		 //********* ELIMINAR ******************
		 	@GetMapping("/delUsuario/{id}")
		 	public String delUsuario(@PathVariable("id") Long id_usuario, Model modelo) {
		 		//elimno el Usuario por id 
		 		servicioUsuario.Eliminar(id_usuario);
                //llamo a la lista de Usuarios actualizado  		 		
		 		modelo.addAttribute("Producto",servicioUsuario.Listar());
		 		
		 	  return "redirect:/Usuario";
		 	}
		 	
}


