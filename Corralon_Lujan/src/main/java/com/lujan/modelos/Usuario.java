package com.lujan.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Usuario")
public class Usuario {
	//CLAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
     //ATRIBUTOS 
	@Column(name= "nombre",nullable=false,length=50)
	private String nombre;
	
	@Column(name= "password",nullable=false,length=50)
	private String  password;
	
	//CONSTRUCTOR VACIO
	public Usuario() {
	}
	//CONSTRUCTOR CON DATOS
	public Usuario(long id_usuario, String nombre, String password) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.password = password;
	}
	//GETS Y SETS

	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}