package com.proyectonu1.app.entidades;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class Clubes {
	

	private String id;
	
	@DocumentReference
	private Entrenadores entrenadores;
	
	@DocumentReference
	private List<Jugadores> jugador;
	
	@DocumentReference
	private Asociacion asociacion;
	
	@DocumentReference
	private List<Competicion> competicion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
