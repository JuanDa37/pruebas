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
import com.proyectonu1.app.entidades.EstudianteDocument;
import com.proyectonu1.repository.EstudianteRepository;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
	
	@Autowired
	private EstudianteRepository EstudianteRepository;
	
	@GetMapping("/")
    public List<EstudianteDocument> getAllEquipos() {
        return EstudianteRepository.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteDocument getEquipoById(@PathVariable String id) {
        return EstudianteRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public EstudianteDocument saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        EstudianteDocument EstudianteDocument = mapper.convertValue(body, EstudianteDocument.class);
        return EstudianteRepository.save(EstudianteDocument);
    }

    @PutMapping("/{id}")
    public EstudianteDocument updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        EstudianteDocument EstudianteDocument = mapper.convertValue(body, EstudianteDocument.class);
        EstudianteDocument.setId(id);
        return EstudianteRepository.save(EstudianteDocument);
    }

    @DeleteMapping("/{id}")
    public EstudianteDocument deleteEquipo(@PathVariable String id) {
        EstudianteDocument EstudianteDocument = EstudianteRepository.findById(id).orElse(null);
        EstudianteRepository.deleteById(id);
        return EstudianteDocument;
    }

}
