package com.lujan.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lujan.modelos.Cliente;
import com.lujan.servicios.ServicioCliente;


@Controller
public class ControlCliente {

		//Instanciar Servicio  de ServicioCliente para poder utilizar los servicios 
		 	@Autowired
		 	private ServicioCliente servicioCliente;
		
		//********** LISTAR y AGREGAR NUEVO PRODUCTO *************
		 	
		 	@GetMapping("/Cliente")
		 	public String Cliente(Model modelo) {
				modelo.addAttribute("Cliente",servicioCliente.Listar());
				/*Para un nuevo Cliente*/
				Cliente cliente = new Cliente();
			    modelo.addAttribute("newCliente",cliente);
			    modelo.addAttribute("editCliente",cliente);
			  return "Cliente";
		    }
		 	
		//********* GUARDAR ******************
		
		 	@PostMapping("/saveCliente")
		    public String saveCliente(@ModelAttribute Cliente cliente) {
		 		servicioCliente.Guardar(cliente);
		 	  
		 	  return "redirect:/Cliente";//vuelve a listar Clientes con el nuevo añadido
		 	}
		 	
		 //********* EDITAR ******************
		 	@GetMapping("/editCliente/{id}")
		 	public String editCliente(@PathVariable("id") Long id_cliente, Model modelo) {
		 		//busca el Cliente por Id 
		 		Cliente editCliente = servicioCliente.Buscar(id_cliente);
		 		 //pasar a html
		         modelo.addAttribute("editCliente",editCliente);
		 	 return "modifCliente";/*llamo a otra pagina*/
		 		 
		 	}
		
		 //********* ELIMINAR ******************
		 	@GetMapping("/delCliente/{id}")
		 	public String delCliente(@PathVariable("id") Long id_cliente, Model modelo) {
		 		//elimno el Cliente por id 
		 		servicioCliente.Eliminar(id_cliente);
                //llamo a la lista de Clientes actualizado  		 		
		 		modelo.addAttribute("Cliente",servicioCliente.Listar());
		 		
		 	  return "redirect:/Cliente";
		 	}
		 	
}

