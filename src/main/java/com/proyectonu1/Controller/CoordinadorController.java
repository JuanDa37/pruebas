package com.proyectonu1.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectonu1.app.entidades.CoordinadorDocument;
import com.proyectonu1.repository.CoordinadorRepository;

import jakarta.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/coordinador")
public class CoordinadorController {
	
	@Autowired
	private CoordinadorRepository CoordinadorRepository;
	
	@GetMapping("/")
    public List<CoordinadorDocument> getAllEquipos() {
        return CoordinadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public CoordinadorDocument getEquipoById(@PathVariable String id) {
        return CoordinadorRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public CoordinadorDocument saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        CoordinadorDocument CoordinadorDocument = mapper.convertValue(body, CoordinadorDocument.class);
        return CoordinadorRepository.save(CoordinadorDocument);
    }

    @PutMapping("/{id}")
    public CoordinadorDocument updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        CoordinadorDocument CoordinadorDocument = mapper.convertValue(body, CoordinadorDocument.class);
        CoordinadorDocument.setId(id);
        return CoordinadorRepository.save(CoordinadorDocument);
    }

    @DeleteMapping("/{id}")
    public CoordinadorDocument deleteEquipo(@PathVariable String id) {
        CoordinadorDocument CoordinadorDocument = CoordinadorRepository.findById(id).orElse(null);
        CoordinadorRepository.deleteById(id);
        return CoordinadorDocument;
    }

}
