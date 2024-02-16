package com.proyectonu1.app.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "informe")
public class informe {
	
	private String id;
	
	private int puntajeTotalSaberPro;
	
	private String puntajeTotalSaberProNivel;
	
	private int lecturaCritica;
	
	private String lecturaCriticaNivel;
	
	private int comunicacionEscrita;
	
	private String comunicacionEscritaNivel;
	
	private int razonamientoCuantitativo;
	
	private String razonamientoCuantitativoNivel;
	
	private int ingles;
	
	private String inglesNivel;
	
	private int competenciasCiudadanas;
	
	private String competenciasCiudadanasNivel;
	
	private int formulacionDeProyectosDeIngenieria;
	
	private String formulacionDeProyectosDeIngenieriaNivel;
	
	private int pensamientoCientificoMatematicasYEstadistica;
	
	private String pensamientoCientificoMatematicasYEstadisticaNivel;
	
	private int disenoDeSoftware;
	
	private String disenoDeSoftwareNivel;
	
	private String inglesDeNivel;
	
	private Date date;
	
	private boolean revisado;
	
	@DocumentReference
	private EstudianteDocument estudiante;

	public informe() {
	}

	public informe(String id, int puntajeTotalSaberPro, String puntajeTotalSaberProNivel, int lecturaCritica,
			String lecturaCriticaNivel, int comunicacionEscrita, String comunicacionEscritaNivel,
			int razonamientoCuantitativo, String razonamientoCuantitativoNivel, int ingles, String inglesNivel,
			int competenciasCiudadanas, String competenciasCiudadanasNivel, int formulacionDeProyectosDeIngenieria,
			String formulacionDeProyectosDeIngenieriaNivel, int pensamientoCientificoMatematicasYEstadistica,
			String pensamientoCientificoMatematicasYEstadisticaNivel, int disenoDeSoftware,
			String disenoDeSoftwareNivel, String inglesDeNivel, Date date, boolean revisado,
			EstudianteDocument estudiante) {
		this.id = id;
		this.puntajeTotalSaberPro = puntajeTotalSaberPro;
		this.puntajeTotalSaberProNivel = puntajeTotalSaberProNivel;
		this.lecturaCritica = lecturaCritica;
		this.lecturaCriticaNivel = lecturaCriticaNivel;
		this.comunicacionEscrita = comunicacionEscrita;
		this.comunicacionEscritaNivel = comunicacionEscritaNivel;
		this.razonamientoCuantitativo = razonamientoCuantitativo;
		this.razonamientoCuantitativoNivel = razonamientoCuantitativoNivel;
		this.ingles = ingles;
		this.inglesNivel = inglesNivel;
		this.competenciasCiudadanas = competenciasCiudadanas;
		this.competenciasCiudadanasNivel = competenciasCiudadanasNivel;
		this.formulacionDeProyectosDeIngenieria = formulacionDeProyectosDeIngenieria;
		this.formulacionDeProyectosDeIngenieriaNivel = formulacionDeProyectosDeIngenieriaNivel;
		this.pensamientoCientificoMatematicasYEstadistica = pensamientoCientificoMatematicasYEstadistica;
		this.pensamientoCientificoMatematicasYEstadisticaNivel = pensamientoCientificoMatematicasYEstadisticaNivel;
		this.disenoDeSoftware = disenoDeSoftware;
		this.disenoDeSoftwareNivel = disenoDeSoftwareNivel;
		this.inglesDeNivel = inglesDeNivel;
		this.date = date;
		this.revisado = revisado;
		this.estudiante = estudiante;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPuntajeTotalSaberPro() {
		return puntajeTotalSaberPro;
	}

	public void setPuntajeTotalSaberPro(int puntajeTotalSaberPro) {
		this.puntajeTotalSaberPro = puntajeTotalSaberPro;
	}

	public String getPuntajeTotalSaberProNivel() {
		return puntajeTotalSaberProNivel;
	}

	public void setPuntajeTotalSaberProNivel(String puntajeTotalSaberProNivel) {
		this.puntajeTotalSaberProNivel = puntajeTotalSaberProNivel;
	}

	public int getLecturaCritica() {
		return lecturaCritica;
	}

	public void setLecturaCritica(int lecturaCritica) {
		this.lecturaCritica = lecturaCritica;
	}

	public String getLecturaCriticaNivel() {
		return lecturaCriticaNivel;
	}

	public void setLecturaCriticaNivel(String lecturaCriticaNivel) {
		this.lecturaCriticaNivel = lecturaCriticaNivel;
	}

	public int getComunicacionEscrita() {
		return comunicacionEscrita;
	}

	public void setComunicacionEscrita(int comunicacionEscrita) {
		this.comunicacionEscrita = comunicacionEscrita;
	}

	public String getComunicacionEscritaNivel() {
		return comunicacionEscritaNivel;
	}

	public void setComunicacionEscritaNivel(String comunicacionEscritaNivel) {
		this.comunicacionEscritaNivel = comunicacionEscritaNivel;
	}

	public int getRazonamientoCuantitativo() {
		return razonamientoCuantitativo;
	}

	public void setRazonamientoCuantitativo(int razonamientoCuantitativo) {
		this.razonamientoCuantitativo = razonamientoCuantitativo;
	}

	public String getRazonamientoCuantitativoNivel() {
		return razonamientoCuantitativoNivel;
	}

	public void setRazonamientoCuantitativoNivel(String razonamientoCuantitativoNivel) {
		this.razonamientoCuantitativoNivel = razonamientoCuantitativoNivel;
	}

	public int getIngles() {
		return ingles;
	}

	public void setIngles(int ingles) {
		this.ingles = ingles;
	}

	public String getInglesNivel() {
		return inglesNivel;
	}

	public void setInglesNivel(String inglesNivel) {
		this.inglesNivel = inglesNivel;
	}

	public int getCompetenciasCiudadanas() {
		return competenciasCiudadanas;
	}

	public void setCompetenciasCiudadanas(int competenciasCiudadanas) {
		this.competenciasCiudadanas = competenciasCiudadanas;
	}

	public String getCompetenciasCiudadanasNivel() {
		return competenciasCiudadanasNivel;
	}

	public void setCompetenciasCiudadanasNivel(String competenciasCiudadanasNivel) {
		this.competenciasCiudadanasNivel = competenciasCiudadanasNivel;
	}

	public int getFormulacionDeProyectosDeIngenieria() {
		return formulacionDeProyectosDeIngenieria;
	}

	public void setFormulacionDeProyectosDeIngenieria(int formulacionDeProyectosDeIngenieria) {
		this.formulacionDeProyectosDeIngenieria = formulacionDeProyectosDeIngenieria;
	}

	public String getFormulacionDeProyectosDeIngenieriaNivel() {
		return formulacionDeProyectosDeIngenieriaNivel;
	}

	public void setFormulacionDeProyectosDeIngenieriaNivel(String formulacionDeProyectosDeIngenieriaNivel) {
		this.formulacionDeProyectosDeIngenieriaNivel = formulacionDeProyectosDeIngenieriaNivel;
	}

	public int getPensamientoCientificoMatematicasYEstadistica() {
		return pensamientoCientificoMatematicasYEstadistica;
	}

	public void setPensamientoCientificoMatematicasYEstadistica(int pensamientoCientificoMatematicasYEstadistica) {
		this.pensamientoCientificoMatematicasYEstadistica = pensamientoCientificoMatematicasYEstadistica;
	}

	public String getPensamientoCientificoMatematicasYEstadisticaNivel() {
		return pensamientoCientificoMatematicasYEstadisticaNivel;
	}

	public void setPensamientoCientificoMatematicasYEstadisticaNivel(
			String pensamientoCientificoMatematicasYEstadisticaNivel) {
		this.pensamientoCientificoMatematicasYEstadisticaNivel = pensamientoCientificoMatematicasYEstadisticaNivel;
	}

	public int getDisenoDeSoftware() {
		return disenoDeSoftware;
	}

	public void setDisenoDeSoftware(int disenoDeSoftware) {
		this.disenoDeSoftware = disenoDeSoftware;
	}

	public String getDisenoDeSoftwareNivel() {
		return disenoDeSoftwareNivel;
	}

	public void setDisenoDeSoftwareNivel(String disenoDeSoftwareNivel) {
		this.disenoDeSoftwareNivel = disenoDeSoftwareNivel;
	}

	public String getInglesDeNivel() {
		return inglesDeNivel;
	}

	public void setInglesDeNivel(String inglesDeNivel) {
		this.inglesDeNivel = inglesDeNivel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isRevisado() {
		return revisado;
	}

	public void setRevisado(boolean revisado) {
		this.revisado = revisado;
	}

	public EstudianteDocument getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteDocument estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
