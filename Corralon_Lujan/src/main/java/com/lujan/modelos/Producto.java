package com.lujan.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Producto")
public class Producto {
	//CLAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_prod;
     //ATRIBUTOS 
	@Column(name= "descripcion",nullable=false,length=200)
	private String descripcion;
	
	@Column(name= "precio",nullable=false,scale=2)//scale: INDICA CUANTOS DECIMALES 
	private double  precio;
	
	
	@Column(name= "stock",nullable=false)
	private int  stock;
	public Producto() {
	}
	public Producto(long id_prod, String descripcion, double precio, int stock) {
		super();
		this.id_prod = id_prod;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	public long getId_prod() {
		return id_prod;
	}
	public void setId_prod(long id_producto) {
		this.id_prod = id_producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	


}