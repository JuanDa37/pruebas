package com.proyectonu1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectonu1.app.entidades.Equipo;
import com.proyectonu1.repository.EquipoRepository;
import com.proyectonu1.Exception.Exception;

@Controller
@RequestMapping("/equi")
public class EquipoTemplates {
	
	@Autowired
	private EquipoRepository EquipoRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("equipos", EquipoRepository.findAll());
        return "equipos-list";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "equipos-form";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("equipo", EquipoRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "equipos-form";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("equipo") Equipo equipo) {
        if (equipo.getId().isEmpty()) {
            equipo.setId(null);
        }
        EquipoRepository.save(equipo);
        return "redirect:/equipos/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        EquipoRepository.deleteById(id);
        return "redirect:/equipos/";
    }

}
