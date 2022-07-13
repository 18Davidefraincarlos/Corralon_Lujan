package com.lujan.modelos;


//import java.util.Date;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Factura")
public class Factura {
	//CLAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_factura;
     //ATRIBUTOS 
	@Column(name= "fecha",nullable=false)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_emp")
	private Empleado empleado;

	@Column(name= "formapago",nullable=false,length=50)
	private String formapago;

	public Factura() {
	}

	public Factura(long id_factura, Date fecha, Cliente cliente, Empleado empleado, String formapago) {
		super();
		this.id_factura = id_factura;
		this.fecha = fecha;
		this.cliente = cliente;
		this.empleado = empleado;
		this.formapago = formapago;
	}

	public long getId_factura() {
		return id_factura;
	}

	public void setId_factura(long id_factura) {
		this.id_factura = id_factura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}
	
}