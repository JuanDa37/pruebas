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
import com.proyectonu1.app.entidades.Competicion;
import com.proyectonu1.app.entidades.Equipo;
import com.proyectonu1.repository.CompeticionesRepository;
import com.proyectonu1.repository.EquipoRepository;

@RestController
@RequestMapping("/api/competicion")
public class CompeticionesController {
	
	@Autowired
	private CompeticionesRepository CompeticionesRepository;
	
	@GetMapping("/")
    public List<Competicion> getAllEquipos() {
        return CompeticionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Competicion getEquipoById(@PathVariable String id) {
        return CompeticionesRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public Competicion saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Competicion competicion = mapper.convertValue(body, Competicion.class);
        return CompeticionesRepository.save(competicion);
    }

    @PutMapping("/{id}")
    public Competicion updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Competicion competicion = mapper.convertValue(body, Competicion.class);
        competicion.setId(id);
        return CompeticionesRepository.save(competicion);
    }

    @DeleteMapping("/{id}")
    public Competicion deleteEquipo(@PathVariable String id) {
        Competicion competicion = CompeticionesRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        CompeticionesRepository.deleteById(id);
        return competicion;
    }

}
