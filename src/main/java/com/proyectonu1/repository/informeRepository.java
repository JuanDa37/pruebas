package com.proyectonu1.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectonu1.app.entidades.informe;

public interface informeRepository extends MongoRepository<informe, String>{
	
	 List<informe> findByEstudianteId(String estudianteId);

}
