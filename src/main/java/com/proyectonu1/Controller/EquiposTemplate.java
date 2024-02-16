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
import com.proyectonu1.app.entidades.Asociacion;
import com.proyectonu1.app.entidades.Entrenadores;
import com.proyectonu1.app.entidades.Equipos;
import com.proyectonu1.repository.AsociacionRepository;
import com.proyectonu1.repository.EquiposRepository;
import com.proyectonu1.repository.EntrenadoresRepository;

@Controller
@RequestMapping("/equipos")
public class EquiposTemplate {
	
	@Autowired
	private EquiposRepository EquiposRepository;
	
	@Autowired
	private AsociacionRepository AsociacionRepository;
	
	@Autowired
	private EntrenadoresRepository EntrenadoresRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("equipos", EquiposRepository.findAll());
        List<Equipos> equiposs = EquiposRepository.findAll();
        for (Equipos equiposss : equiposs) {
        	equiposss.getAsociacion();
        	equiposss.getEntrenadores();
        }
        return "lista-equipos";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("equipos", new Equipos());
        List<Asociacion> Asociacionnnn = AsociacionRepository.findAll();
        model.addAttribute("asociacion", Asociacionnnn);
        List<Entrenadores> Entrenadores = EntrenadoresRepository.findAll();
        model.addAttribute("entrenadores", Entrenadores);
        return "formulario-equipos";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("equipos", EquiposRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        List<Asociacion> Asociacion = AsociacionRepository.findAll();
        model.addAttribute("asociacion", Asociacion);
        List<Entrenadores> Entrenadores = EntrenadoresRepository.findAll();
        model.addAttribute("entrenadores", Entrenadores);
        return "formulario-equipos";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("equipos") Equipos equipos) {
        if (equipos.getId().isEmpty()) {
            equipos.setId(null);
        }
        EquiposRepository.save(equipos);
        return "redirect:/equipos/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        EquiposRepository.deleteById(id);
        return "redirect:/equipos/";
    }

}
