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
import com.proyectonu1.app.entidades.Asociacion;
import com.proyectonu1.repository.AsociacionRepository;

@RestController
@RequestMapping("/api/asociacion")
public class AsociacionController {
	
	@Autowired
	private AsociacionRepository AsociacionRepository;
	
	@GetMapping("/")
    public List<Asociacion> getAllEquipos() {
        return AsociacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Asociacion getEquipoById(@PathVariable String id) {
        return AsociacionRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public Asociacion saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Asociacion asociacion = mapper.convertValue(body, Asociacion.class);
        return AsociacionRepository.save(asociacion);
    }

    @PutMapping("/{id}")
    public Asociacion updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Asociacion asociacion = mapper.convertValue(body, Asociacion.class);
        asociacion.setId(id);
        return AsociacionRepository.save(asociacion);
    }

    @DeleteMapping("/{id}")
    public Asociacion deleteEquipo(@PathVariable String id) {
        Asociacion asociacion = AsociacionRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        AsociacionRepository.deleteById(id);
        return asociacion;
    }

}
