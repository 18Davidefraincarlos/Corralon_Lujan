package com.lujan.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lujan.modelos.Empleado;
import com.lujan.servicios.ServicioEmpleado;


@Controller
public class ControlEmpleado {

		//Instanciar Servicio  de ServicioEmpleado para poder utilizar los servicios 
		 	@Autowired
		 	private ServicioEmpleado servicioEmpleado;
		
		//********** LISTAR y AGREGAR NUEVO Empleado *************
		 	
		 	@GetMapping("/Empleado")
		 	public String Empleado(Model modelo) {
				modelo.addAttribute("Empleado",servicioEmpleado.Listar());
				/*Para un nuevo Empleado*/
				Empleado empleado = new Empleado();
			    modelo.addAttribute("newEmpleado",empleado);
			    modelo.addAttribute("editEmpleado",empleado);
			  return "Empleado";
		    }
		 	
		//********* GUARDAR ******************
		
		 	@PostMapping("/saveEmpleado")
		    public String saveEmpleado(@ModelAttribute Empleado empleado) {
		 		servicioEmpleado.Guardar(empleado);
		 	  
		 	  return "redirect:/Empleado";//vuelve a listar Empleados con el nuevo añadido
		 	}
		 	
		 //********* EDITAR ******************
		 	@GetMapping("/editEmpleado/{id}")
		 	public String editProducto(@PathVariable("id") Long id_empleado, Model modelo) {
		 		//busca el Empleado por Id 
		 		Empleado editEmpleado = servicioEmpleado.Buscar(id_empleado);
		 		 //pasar a html
		         modelo.addAttribute("editEmpleado",editEmpleado);
		 	 return "Empleado/editarEmpleado";/*llamo a otra pagina*/
		 		 
		 	}
		
		 //********* ELIMINAR ******************
		 	@GetMapping("/delEmpleado/{id}")
		 	public String delEmpleado(@PathVariable("id") Long id_empleado, Model modelo) {
		 		//elimno al Empleado por id 
		 		servicioEmpleado.Eliminar(id_empleado);
                //llamo a la lista de Empleados actualizado  		 		
		 		modelo.addAttribute("Empleado",servicioEmpleado.Listar());
		 		
		 	  return "redirect:/Empleado";
		 	}
		 	
}


