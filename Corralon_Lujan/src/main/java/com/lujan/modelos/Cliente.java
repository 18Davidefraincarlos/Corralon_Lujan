package com.lujan.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Cliente")
public class Cliente {
	//CLAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cliente;
     //ATRIBUTOS 
	@Column(name= "nomClie",nullable=false,length=100)//length:PARA PONER LIMITE/RANGO SOLO PARA STRING
	private String nomClie;
	
	@Column(name= "dniClie",nullable=false,updatable = false)//updatable = false NO SE PUEDE ACTUALIZAR
	private int  dniClie;
	
	
	@Column(name= "celular",nullable=false)
	private int  celular;
	public Cliente() {
	}
	public Cliente(long id_cliente, String nomClie, int dniClie, int celular) {
		super();
		this.id_cliente = id_cliente;
		this.nomClie = nomClie;
		this.dniClie = dniClie;
		this.celular = celular;
	}
	public long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNomClie() {
		return nomClie;
	}
	public void setNomClie(String nomClie) {
		this.nomClie = nomClie;
	}
	public int getDniClie() {
		return dniClie;
	}
	public void setDniClie(int precio) {
		this.dniClie = precio;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	


}