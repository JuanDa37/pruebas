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
import com.proyectonu1.app.entidades.Asociacion;
import com.proyectonu1.repository.AsociacionRepository;

@Controller
@RequestMapping("/asociacion")
public class AsociacionTemplates {
	
	@Autowired
	private AsociacionRepository AsociacionRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("asociacion", AsociacionRepository.findAll());
        return "lista-asociacion";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "formulario-asociacion";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("asociacion", AsociacionRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-asociacion";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("asociacion") Asociacion asociacion) {
        if (asociacion.getId().isEmpty()) {
            asociacion.setId(null);
        }
        AsociacionRepository.save(asociacion);
        return "redirect:/asociacion/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        AsociacionRepository.deleteById(id);
        return "redirect:/asociacion/";
    }

}
