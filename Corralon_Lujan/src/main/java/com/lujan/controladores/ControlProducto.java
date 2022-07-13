package com.lujan.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lujan.modelos.Producto;
import com.lujan.servicios.ServicioProducto;


@Controller
public class ControlProducto {

		//Instanciar Servicio  de ServicioProducto para poder utilizar los servicios 
		 	@Autowired
		 	private ServicioProducto servicioProducto;
		
		//********** LISTAR y AGREGAR NUEVO PRODUCTO *************
		 	
		 	@GetMapping("/Producto")
		 	public String Producto(Model modelo) {
				modelo.addAttribute("Producto",servicioProducto.Listar());
				/*Para un nuevo producto*/
				Producto producto = new Producto();
			    modelo.addAttribute("newProducto",producto);
			    modelo.addAttribute("editProducto",producto);
			  return "Producto";
		    }
		 	
		//********* GUARDAR ******************
		
		 	@PostMapping("/saveProducto")
		    public String saveProducto(@ModelAttribute Producto producto) {
		 		servicioProducto.Guardar(producto);
		 	  
		 	  return "redirect:/Producto";//vuelve a listar producto con el nuevo añadido
		 	}
		 	
		 // ******** EDITAR ******************
		 	@GetMapping("/editProducto/{id}")
		 	public String editProducto(@PathVariable("id") Long id_producto, Model modelo) {
		 		//busca el producto por Id 
		         Producto editProducto = servicioProducto.Buscar(id_producto);
		 		 //pasar a html
		         modelo.addAttribute("editProducto",editProducto);
		 	 return "Producto/editarProducto";/*llamo a otra pagina*/
		 		 
		 	} 
		
		 //********* ELIMINAR ******************
		 	@GetMapping("/delProducto/{id}")
		 	public String delProducto(@PathVariable("id") Long id_producto, Model modelo) {
		 		//elimno el producto por id 
		 		servicioProducto.Eliminar(id_producto);
                //llamo a la lista de productos actualizado  		 		
		 		modelo.addAttribute("Producto",servicioProducto.Listar());
		 		
		 	  return "redirect:/Producto";
		 	}
		 	
}

