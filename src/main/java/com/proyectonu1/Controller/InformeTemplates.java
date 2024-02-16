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
import com.proyectonu1.app.entidades.EstudianteDocument;
import com.proyectonu1.app.entidades.informe;
import com.proyectonu1.repository.EntrenadoresRepository;
import com.proyectonu1.repository.informeRepository;
import com.proyectonu1.repository.EstudianteRepository;

@Controller
@RequestMapping("/informe")
public class InformeTemplates {
	
	@Autowired
	private informeRepository InformeRepository;
	
	@Autowired
	private EstudianteRepository EstudianteRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("informe", InformeRepository.findAll());
        List<informe> informe = InformeRepository.findAll();
        for(informe Informe: informe) {
        	Informe.getEstudiante();
        }
        return "lista-informe";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("informe", new informe());
        List<EstudianteDocument> EstudianteDocument = EstudianteRepository.findAll();
        model.addAttribute("estudiante", EstudianteDocument);
        return "formulario-informe";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("informe", InformeRepository.findById(id).orElse(null));
        List<EstudianteDocument> EstudianteDocument = EstudianteRepository.findAll();
        model.addAttribute("estudiante", EstudianteDocument);
        return "formulario-informe";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("informe") informe informe) {
        if (informe.getId().isEmpty()) {
            informe.setId(null);
        }
        InformeRepository.save(informe);
        return "redirect:/informe/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        InformeRepository.deleteById(id);
        return "redirect:/informe/";
    }

}
