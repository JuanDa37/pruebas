package com.proyectonu1.app.entidades;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Competicion {
	
	@Id
	private String id;
	
	private String nombre;
	
	private int MontoPremio;
	
	private String FechaInicio;
	
	private String FechaFin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMontoPremio() {
		return MontoPremio;
	}

	public void setMontoPremio(int montoPremio) {
		MontoPremio = montoPremio;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}
	
	
	
	
	
	
	
	

}
