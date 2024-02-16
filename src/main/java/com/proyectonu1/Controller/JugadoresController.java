package com.proyectonu1.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.Jugadores;
import com.proyectonu1.repository.JugadoresRepository;

@RestController
@RequestMapping("/api/jugadores")
public class JugadoresController {
	
	@Autowired
	private JugadoresRepository JugadoresRepository;
	
	@GetMapping("/")
    public List<Jugadores> getAllEquipos() {
        return JugadoresRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jugadores getEquipoById(@PathVariable String id) {
        return JugadoresRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public Jugadores saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Jugadores jugadores = mapper.convertValue(body, Jugadores.class);
        return JugadoresRepository.save(jugadores);
    }

    @PutMapping("/{id}")
    public Jugadores updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Jugadores jugadores = mapper.convertValue(body, Jugadores.class);
        jugadores.setId(id);
        return JugadoresRepository.save(jugadores);
    }

    @DeleteMapping("/{id}")
    public Jugadores deleteEquipo(@PathVariable String id) {
        Jugadores jugadores = JugadoresRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        JugadoresRepository.deleteById(id);
        return jugadores;
    }

}
