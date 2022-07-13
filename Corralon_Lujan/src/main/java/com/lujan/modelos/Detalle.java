package com.lujan.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Detalle")
public class Detalle {
	//CLAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_detalle;
     //ATRIBUTOS 
	@ManyToOne
	@JoinColumn(name="id_factura")
	private Factura factura ;
	
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Producto producto;
	
	@Column(name= "cantidad",nullable=false)
	private int cantidad;

	@Column(name= "subtotal",nullable=false,scale=3)
	private double subtotal;


	public Detalle() {
	}


	public Detalle(long id_detalle, Factura factura, Producto producto, int cantidad, double subtotal) {
		super();
		this.id_detalle = id_detalle;
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}


	public long getId_detalle() {
		return id_detalle;
	}


	public void setId_detalle(long id_detalle) {
		this.id_detalle = id_detalle;
	}


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
