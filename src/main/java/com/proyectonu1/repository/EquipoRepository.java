package com.proyectonu1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectonu1.app.entidades.Equipo;

public interface EquipoRepository extends MongoRepository<Equipo, String>{

}
