package com.proyectonu1.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiante")
public class EstudianteDocument {
	
	@Id
	private String id;
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	private String primerApellido;
	
	private String segundoApellido;
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String correoElectronico;
	
	private String numeroTelefonico;
	
	private String usuario;
	
	private String contrasena;
	
	@DBRef
	private informe informe;

	public EstudianteDocument() {
	}

	public EstudianteDocument(String id, String tipoDocumento, String numeroDocumento, String primerApellido,
			String segundoApellido, String primerNombre, String segundoNombre, String correoElectronico,
			String numeroTelefonico, String usuario, String contrasena, com.proyectonu1.app.entidades.informe informe) {
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.correoElectronico = correoElectronico;
		this.numeroTelefonico = numeroTelefonico;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.informe = informe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public informe getInforme() {
		return informe;
	}

	public void setInforme(informe informe) {
		this.informe = informe;
	}
	
	
	
	
	
	
	
	
	
	

}
