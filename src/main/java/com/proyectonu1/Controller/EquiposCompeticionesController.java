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
import com.proyectonu1.app.entidades.Equipo;
import com.proyectonu1.app.entidades.EquiposCompeticiones;
import com.proyectonu1.repository.EquipoRepository;
import com.proyectonu1.repository.EquiposCompeticionesRepository;

@RestController
@RequestMapping("/api/equiposcompeticiones")
public class EquiposCompeticionesController {
	
	@Autowired
	private EquiposCompeticionesRepository EquiposCompeticionesRepository;
	
	@GetMapping("/")
    public List<EquiposCompeticiones> getAllEquipos() {
        return EquiposCompeticionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public EquiposCompeticiones getEquipoById(@PathVariable String id) {
        return EquiposCompeticionesRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public EquiposCompeticiones saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        EquiposCompeticiones equiposcompeticiones = mapper.convertValue(body, EquiposCompeticiones.class);
        return EquiposCompeticionesRepository.save(equiposcompeticiones);
    }

    @PutMapping("/{id}")
    public EquiposCompeticiones updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        EquiposCompeticiones equiposcompeticiones = mapper.convertValue(body, EquiposCompeticiones.class);
        equiposcompeticiones.setId(id);
        return EquiposCompeticionesRepository.save(equiposcompeticiones);
    }

    @DeleteMapping("/{id}")
    public EquiposCompeticiones deleteEquipo(@PathVariable String id) {
        EquiposCompeticiones equiposcompeticiones = EquiposCompeticionesRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        EquiposCompeticionesRepository.deleteById(id);
        return equiposcompeticiones;
    }

}
