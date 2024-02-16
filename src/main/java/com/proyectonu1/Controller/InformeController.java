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
import com.proyectonu1.app.entidades.informe;
import com.proyectonu1.repository.EntrenadoresRepository;
import com.proyectonu1.repository.informeRepository;

@RestController
@RequestMapping("/api/informes")
public class InformeController {
	
	@Autowired
	private informeRepository InformeRepository;
	
	@GetMapping("/")
    public List<informe> getAllEquipos() {
        return InformeRepository.findAll();
    }

    @GetMapping("/{id}")
    public informe getEquipoById(@PathVariable String id) {
        return InformeRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public informe saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        informe informe = mapper.convertValue(body, informe.class);
        return InformeRepository.save(informe);
    }

    @PutMapping("/{id}")
    public informe updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        informe informe = mapper.convertValue(body, informe.class);
        informe.setId(id);
        return InformeRepository.save(informe);
    }

    @DeleteMapping("/{id}")
    public informe deleteEquipo(@PathVariable String id) {
        informe informe = InformeRepository.findById(id).orElse(null);
        InformeRepository.deleteById(id);
        return informe;
    }

}
