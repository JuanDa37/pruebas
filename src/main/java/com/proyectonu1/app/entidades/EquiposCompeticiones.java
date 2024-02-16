package com.proyectonu1.app.entidades;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class EquiposCompeticiones {
	
	@Id
	private String id;
	
	@DBRef
	private Equipos Equipos;
	
	@DBRef
	private Competicion Competicion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Equipos getEquipos() {
		return Equipos;
	}

	public void setEquipos(Equipos equipos) {
		Equipos = equipos;
	}

	public Competicion getCompeticion() {
		return Competicion;
	}

	public void setCompeticion(Competicion competicion) {
		Competicion = competicion;
	}
	
	
	
	

}
