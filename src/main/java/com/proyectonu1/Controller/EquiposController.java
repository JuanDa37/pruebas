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
import com.proyectonu1.app.entidades.Equipos;
import com.proyectonu1.repository.EquiposRepository;

@RestController
@RequestMapping("/api/equipos")
public class EquiposController {
	
	@Autowired
	private EquiposRepository EquiposRepository;
	
	@GetMapping("/")
    public List<Equipos> getAllEquipos() {
        return EquiposRepository.findAll();
    }

    @GetMapping("/{id}")
    public Equipos getEquipoById(@PathVariable String id) {
        return EquiposRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public Equipos saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Equipos equipos = mapper.convertValue(body, Equipos.class);
        return EquiposRepository.save(equipos);
    }

    @PutMapping("/{id}")
    public Equipos updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Equipos equipos = mapper.convertValue(body, Equipos.class);
        equipos.setId(id);
        return EquiposRepository.save(equipos);
    }

    @DeleteMapping("/{id}")
    public Equipos deleteEquipo(@PathVariable String id) {
        Equipos equipos = EquiposRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        EquiposRepository.deleteById(id);
        return equipos;
    }
	
}
