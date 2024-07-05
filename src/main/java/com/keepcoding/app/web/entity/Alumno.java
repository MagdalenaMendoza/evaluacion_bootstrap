package com.keepcoding.app.web.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length=100)
	private String nombre;
	@Column(nullable = false, length=100)
	private String apellido;
	private int telefono;
	@Column(nullable = false, length=100)
	private String email;
	@Column(nullable = false, length=100)
	private String dni;
	@Column(nullable = false, length=100)
	private String fecha_nac;
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getFecha_nac() {
		return fecha_nac;
	}



	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
