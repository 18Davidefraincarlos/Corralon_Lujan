package com.lujan.controladores;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lujan.modelos.Producto;
import com.lujan.modelos.Cliente;
import com.lujan.modelos.Detalle;
import com.lujan.modelos.Empleado;
import com.lujan.modelos.Factura;
import com.lujan.servicios.ServicioCliente;
import com.lujan.servicios.ServicioDetalle;
import com.lujan.servicios.ServicioEmpleado;
import com.lujan.servicios.ServicioFactura;
import com.lujan.servicios.ServicioProducto;

@Controller
public class ControlFactura {
  
	Factura guardarFac=null;
	//Instanciar Servicios 
	@Autowired
 	private ServicioFactura servicioFactura;
 	@Autowired
 	private ServicioProducto sevicioProducto;
 	@Autowired
 	private ServicioCliente servicioCliente;
 	@Autowired
 	private ServicioEmpleado servicioEmpleado;
 	@Autowired
 	private ServicioDetalle servicioDetalle;
 	
 	//********** LISTAR FACTURAS *************
 	@GetMapping("/Factura")
 	public String Factura(Model modelo) {
	modelo.addAttribute("factura",servicioFactura.Listar());
	 return "Factura";
 }
 
 	// **AGREGAR NUEVA FACTURA*****
 	@GetMapping("/addFactura")
 	public String addFactura(Model modelo) {
	/*Para un nueva factura*/
	Factura factura = new Factura();
	//Detalle detalle =new Detalle();	
	//llamar a todas las listas para factura
	List<Producto> Producto = sevicioProducto.Listar();
	List<Cliente> Cliente = servicioCliente.Listar(); 
	
	List<Empleado> Empleado = servicioEmpleado.Listar();
		//OBJETOS VACIOS 
	     modelo.addAttribute("newFactura",factura);
	   //  modelo.addAttribute("newDetalle",detalle);
	    //LISTA DE OBJETOS CON DATOS
	     modelo.addAttribute("producto",Producto);
		 modelo.addAttribute("cliente",Cliente);
		 modelo.addAttribute("empleado",Empleado);
	     
	return "addFactura";
 }
 	
 //********* GUARDAR ******************

 	@PostMapping("/saveFactura")
   public String saveFactura(@ModelAttribute Factura factura, Model modelo) {
 		
 		servicioFactura.Guardar(factura);
 		Detalle detalle =new Detalle();
 		
 		guardarFac=factura;
 		
 		detalle.setFactura(factura);
 		
 		List<Producto> Producto = sevicioProducto.Listar();
 		modelo.addAttribute("factura",factura);
 	    modelo.addAttribute("Producto",Producto);
 	    modelo.addAttribute("newDetalle",detalle);
 	    return "Detalle";
 	}
 	@PostMapping("/saveDetalle")
    public String saveFactura(@ModelAttribute Detalle detalle, Model modelo) {
  		detalle.setSubtotal(detalle.getCantidad()*detalle.getProducto().getPrecio());
 		
  		List<Producto> Producto = sevicioProducto.Listar();
  		
  		servicioDetalle.Guardar(detalle);
  		
  		Detalle newdetalle =new Detalle();
  		detalle.setFactura(guardarFac);
  		modelo.addAttribute("detalle",detalle);
  		modelo.addAttribute("factura",guardarFac);
  	    modelo.addAttribute("Producto",Producto);
  	    modelo.addAttribute("newDetalle",newdetalle);
  	    return "Detalle";
  	}
  	
       	
   //********* EDITAR ******************
 	/*@GetMapping("/editFactura/{id}")
 	public String editFactua(@PathVariable("id") Long id_factura, Model modelo) {
 		 
 		 Factura factura = servicioFactura.Buscar(id_factura);
 		 List<Producto> producto = sevicioProducto.Listar();
		 modelo.addAttribute("facturacion",factura);
		 modelo.addAttribute("producto",producto);
		 return "modif_Factura";}

 	//********* ELIMINAR ******************
 	@GetMapping("/delFactura/{id}")
 	public String delFactura(@PathVariable("id") Long id_factura, Model modelo) {
 		 
 		// servicioFactura.Eliminar(id_factura);para usar este servicio habilitarlo en servicios factura
 		 modelo.addAttribute("Factura",servicioFactura.Listar());
 		 
 		 return "redirect:/Factura";*/
 	}
 	


