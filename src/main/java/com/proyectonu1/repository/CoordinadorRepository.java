package com.proyectonu1.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyectonu1.app.entidades.CoordinadorDocument;

public interface CoordinadorRepository extends MongoRepository<CoordinadorDocument, String>{
	
	Optional<CoordinadorDocument> findByUsuarioAndContrasena(String usuario, String contrasena);

}
