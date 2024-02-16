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
import com.proyectonu1.app.entidades.Equipos;
import com.proyectonu1.app.entidades.Jugadores;
import com.proyectonu1.repository.JugadoresRepository;
import com.proyectonu1.repository.EquiposRepository;

@Controller
@RequestMapping("/jugadores")
public class JugadoresTemplates {
	
	@Autowired
	private JugadoresRepository JugadoresRepository;
	
	@Autowired
	private EquiposRepository EquiposRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("jugadores", JugadoresRepository.findAll());
        return "lista-jugadores";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("jugadores", new Jugadores());
        List<Equipos> Equiposs = EquiposRepository.findAll();
        model.addAttribute("equipos", Equiposs);
        return "formularios-jugadores";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("jugadores", JugadoresRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        List<Equipos> Equiposs = EquiposRepository.findAll();
        model.addAttribute("equipos", Equiposs);
        return "formularios-jugadores";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("jugadores") Jugadores jugadores) {
        if (jugadores.getId().isEmpty()) {
            jugadores.setId(null);
        }
        
        Equipos Equiposss = EquiposRepository.findById(jugadores.getEquipos().getId()).orElse(null);
        jugadores.setEquipos(Equiposss);
        
        JugadoresRepository.save(jugadores);
        return "redirect:/jugadores/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        JugadoresRepository.deleteById(id);
        return "redirect:/jugadores/";
    }

}
