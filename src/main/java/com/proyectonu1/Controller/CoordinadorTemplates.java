package com.proyectonu1.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectonu1.app.entidades.CoordinadorDocument;
import com.proyectonu1.repository.CoordinadorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CoordinadorTemplates {
	
	@Autowired
	private CoordinadorRepository CoordinadorRepository;
	
	@GetMapping("/coordinador/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("coordinador", CoordinadorRepository.findAll());
        return "lista-coordinador";
    }
	
	@GetMapping("/loginCoordinador")
	public String entrarlogin(Model model) {
	    model.addAttribute("coordinador", new CoordinadorDocument()); // Agrega un objeto coordinador vacío al modelo
	    return "login";
	}
	
	@PostMapping("/loginCoordinador")
	public String ingresarlogin(@RequestParam String usuario, @RequestParam String contrasena, HttpSession sesion, Model model) {
		Optional<CoordinadorDocument> coordinador = CoordinadorRepository.findByUsuarioAndContrasena(usuario, contrasena);
				if(coordinador.isPresent()) {
					sesion.setAttribute("coordinador", coordinador);
					return "redirect:/estudiantes/";
				}
		model.addAttribute("coordinador", new CoordinadorDocument());
		model.addAttribute("errorCredenciales", true);
		return "login";
	}

    @GetMapping("/coordinador/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("coordinador", new CoordinadorDocument());
        return "formulario-coordinador";
    }

    @GetMapping("/coordinador/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("coordinador", CoordinadorRepository.findById(id).orElse(null));
        return "formulario-coordinador";
    }

    @PostMapping("/coordinador/save")
    public String equiposSaveProcess(@ModelAttribute("coordinador") CoordinadorDocument CoordinadorDocument) {
        if (CoordinadorDocument.getId().isEmpty()) {
            CoordinadorDocument.setId(null);
        }
        CoordinadorRepository.save(CoordinadorDocument);
        return "redirect:/coordinador/";
    }

    @GetMapping("/coordinador/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        CoordinadorRepository.deleteById(id);
        return "redirect:/coordinador/";
    }

}
