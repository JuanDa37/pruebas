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
import com.proyectonu1.app.entidades.Entrenadores;
import com.proyectonu1.repository.EntrenadoresRepository;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadoresController {
	
	@Autowired
	private EntrenadoresRepository EntrenadoresRepository;
	
	@GetMapping("/")
    public List<Entrenadores> getAllEquipos() {
        return EntrenadoresRepository.findAll();
    }

    @GetMapping("/{id}")
    public Entrenadores getEquipoById(@PathVariable String id) {
        return EntrenadoresRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public Entrenadores saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Entrenadores Entrenadores = mapper.convertValue(body, Entrenadores.class);
        return EntrenadoresRepository.save(Entrenadores);
    }

    @PutMapping("/{id}")
    public Entrenadores updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Entrenadores Entrenadores = mapper.convertValue(body, Entrenadores.class);
        Entrenadores.setId(id);
        return EntrenadoresRepository.save(Entrenadores);
    }

    @DeleteMapping("/{id}")
    public Entrenadores deleteEquipo(@PathVariable String id) {
        Entrenadores Entrenadores = EntrenadoresRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        EntrenadoresRepository.deleteById(id);
        return Entrenadores;
    }

}
