package com.proyectonu1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectonu1.app.entidades.Jugadores;

public interface JugadoresRepository extends MongoRepository<Jugadores, String>{

}
