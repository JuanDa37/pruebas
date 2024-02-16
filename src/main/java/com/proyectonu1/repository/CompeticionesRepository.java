package com.proyectonu1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectonu1.app.entidades.Competicion;

public interface CompeticionesRepository extends MongoRepository<Competicion, String>{

}
