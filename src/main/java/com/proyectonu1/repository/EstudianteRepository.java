package com.proyectonu1.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectonu1.app.entidades.EstudianteDocument;

public interface EstudianteRepository extends MongoRepository<EstudianteDocument, String>{
	
	Optional<EstudianteDocument> findByUsuarioAndContrasena(String usuario, String contrasena);

}
