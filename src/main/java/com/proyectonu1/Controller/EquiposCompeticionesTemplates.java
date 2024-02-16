package com.proyectonu1.Controller;

import java.util.List;

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
import com.proyectonu1.app.entidades.Equipos;
import com.proyectonu1.app.entidades.EquiposCompeticiones;
import com.proyectonu1.repository.CompeticionesRepository;
import com.proyectonu1.repository.EquipoRepository;
import com.proyectonu1.repository.EquiposCompeticionesRepository;
import com.proyectonu1.repository.EquiposRepository;

@Controller
@RequestMapping("/equiposcompeticiones")
public class EquiposCompeticionesTemplates {
	
	@Autowired
	private EquiposCompeticionesRepository EquiposCompeticionesRepository;
	
	@Autowired
	private EquiposRepository EquiposRepository;
	
	@Autowired
	private CompeticionesRepository CompeticionRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("equiposcompeticiones", EquiposCompeticionesRepository.findAll());
        return "lista-equiposcompeticiones";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("equiposcompeticiones", new EquiposCompeticiones());
        List<Equipos> equipossss = EquiposRepository.findAll();
        model.addAttribute("equipos", equipossss);
        List<Competicion> competicionossss = CompeticionRepository.findAll();
        model.addAttribute("competicion", competicionossss);
        return "formulario-equiposcompeticiones";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("equiposcompeticiones", EquiposCompeticionesRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        List<Equipos> equipossss = EquiposRepository.findAll();
        model.addAttribute("equipos", equipossss);
        List<Competicion> competicionossss = CompeticionRepository.findAll();
        model.addAttribute("competicion", competicionossss);
        return "formulario-equiposcompeticiones";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("equiposcompeticiones") EquiposCompeticiones equiposcompeticiones) {
        if (equiposcompeticiones.getId().isEmpty()) {
            equiposcompeticiones.setId(null);
        }
        EquiposCompeticionesRepository.save(equiposcompeticiones);
        return "redirect:/equiposcompeticiones/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        EquiposCompeticionesRepository.deleteById(id);
        return "redirect:/equiposcompeticiones/";
    }

}
