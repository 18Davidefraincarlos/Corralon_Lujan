package com.lujan.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Empleado")
public class Empleado {
	//CLAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_emp;
     //ATRIBUTOS 
	@Column(name= "nomEmp",nullable=false,length=100)
	private String nomEmp;
	
	@Column(name= "dniEmp",nullable=false)
	private int  dniEmp;
	
	
	@Column(name= "cargo",nullable=false,length=200)
	private String  cargo;
	//CONSTRUCTOR 
	public Empleado() {
	}
    
	public Empleado(long id_emp, String nomEmp, int dniEmp, String cargo) {
		super();
		this.id_emp = id_emp;
		this.nomEmp = nomEmp;
		this.dniEmp = dniEmp;
		this.cargo = cargo;
	}
   //GETS Y SETS 
	public long getId_emp() {
		return id_emp;
	}

	public void setId_emp(long id_emp) {
		this.id_emp = id_emp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public int getDniEmp() {
		return dniEmp;
	}

	public void setDniEmp(int dniEmp) {
		this.dniEmp = dniEmp;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
