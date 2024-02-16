package com.proyectonu1.app.entidades;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Equipos {
	
	@Id
	private String id;

private String nombre;
	
	@DBRef
	private Entrenadores entrenadores;
	
	@DBRef
	private List<Jugadores> jugador;
	
	@DBRef
	private Asociacion asociacion;
	
	@DBRef
	private List<Competicion> competicion;

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

	public Entrenadores getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(Entrenadores entrenadores) {
		this.entrenadores = entrenadores;
	}

	public List<Jugadores> getJugador() {
		return jugador;
	}

	public void setJugador(List<Jugadores> jugador) {
		this.jugador = jugador;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public List<Competicion> getCompeticion() {
		return competicion;
	}

	public void setCompeticion(List<Competicion> competicion) {
		this.competicion = competicion;
	}
	
	
	
	
	
}
