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
import com.proyectonu1.app.entidades.Competicion;
import com.proyectonu1.app.entidades.Equipo;
import com.proyectonu1.repository.CompeticionesRepository;
import com.proyectonu1.repository.EquipoRepository;

@Controller
@RequestMapping("/competicion")
public class CompeticionesTemplates {
	
	@Autowired
	private CompeticionesRepository CompeticionesRepsoitory;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("competicion", CompeticionesRepsoitory.findAll());
        return "lista-competiciones";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "formulario-competiciones";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("competicion", CompeticionesRepsoitory.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-competiciones";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("competicion") Competicion competiciones) {
        if (competiciones.getId().isEmpty()) {
            competiciones.setId(null);
        }
        CompeticionesRepsoitory.save(competiciones);
        return "redirect:/competicion/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        CompeticionesRepsoitory.deleteById(id);
        return "redirect:/competicion/";
    }

}
