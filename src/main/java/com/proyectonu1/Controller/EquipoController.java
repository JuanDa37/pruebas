package com.proyectonu1.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectonu1.app.entidades.Equipo;
import com.proyectonu1.repository.EquipoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectonu1.Exception.Exception;

@RestController
@RequestMapping("/api/equi")
public class EquipoController {
	
	@Autowired
	private EquipoRepository EquipoRepository;
	
	@GetMapping("/")
    public List<Equipo> getAllEquipos() {
        return EquipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable String id) {
        return EquipoRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public Equipo saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Equipo equipo = mapper.convertValue(body, Equipo.class);
        return EquipoRepository.save(equipo);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Equipo equipo = mapper.convertValue(body, Equipo.class);
        equipo.setId(id);
        return EquipoRepository.save(equipo);
    }

    @DeleteMapping("/{id}")
    public Equipo deleteEquipo(@PathVariable String id) {
        Equipo equipo = EquipoRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        EquipoRepository.deleteById(id);
        return equipo;
    }

}
