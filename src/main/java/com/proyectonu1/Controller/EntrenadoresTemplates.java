package com.proyectonu1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.Entrenadores;
import com.proyectonu1.repository.EntrenadoresRepository;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadoresTemplates {
	
	@Autowired
	private EntrenadoresRepository EntrenadoresRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("entrenadores", EntrenadoresRepository.findAll());
        return "lista-entrenadores";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("entrenadores", new Entrenadores());
        return "formulario-entrenadores";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("entrenadores", EntrenadoresRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-entrenadores";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("entrenadores") Entrenadores Entrenadores) {
        if (Entrenadores.getId().isEmpty()) {
            Entrenadores.setId(null);
        }
        EntrenadoresRepository.save(Entrenadores);
        return "redirect:/entrenadores/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        EntrenadoresRepository.deleteById(id);
        return "redirect:/entrenadores/";
    }

}
