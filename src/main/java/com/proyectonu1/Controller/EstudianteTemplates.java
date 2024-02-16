package com.proyectonu1.Controller;

import java.util.Date;
import java.util.List;
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

import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.CoordinadorDocument;
import com.proyectonu1.app.entidades.Entrenadores;
import com.proyectonu1.app.entidades.EstudianteDocument;
import com.proyectonu1.app.entidades.informe;
import com.proyectonu1.repository.EntrenadoresRepository;
import com.proyectonu1.repository.EstudianteRepository;
import com.proyectonu1.repository.informeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class EstudianteTemplates {
	
	@Autowired
	private EstudianteRepository EstudianteRepository;
	
	@Autowired
	private informeRepository InformeRepository;
	
	@GetMapping("/estudiantes/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("estudiante", EstudianteRepository.findAll());
        return "lista-estudiantes";
    }
	
	@GetMapping("/loginEstudiante")
	public String entrarlogin(Model model) {
	    model.addAttribute("estudiante", new EstudianteDocument()); // Agrega un objeto coordinador vacío al modelo
	    return "login-estudiante";
	}
	
	@PostMapping("/loginEstudiante")
	public String ingresarlogin(@RequestParam String usuario, @RequestParam String contrasena, HttpSession sesion, Model model) {
		Optional<EstudianteDocument> estudianteOptional = EstudianteRepository.findByUsuarioAndContrasena(usuario, contrasena);
		if (estudianteOptional.isPresent()) {
		    EstudianteDocument estudiante = estudianteOptional.get();
		    sesion.setAttribute("estudiante", estudiante);
		    return "redirect:/Homeestudiante/";
		}
		model.addAttribute("estudiante", new EstudianteDocument());
		model.addAttribute("errorCredenciales", true);
		return "login-estudiante";
	}

    @GetMapping("/estudiantes/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("estudiante", new EstudianteDocument());
        return "formulario-estudiantes";
    }

    @GetMapping("/estudiantes/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("estudiante", EstudianteRepository.findById(id).orElse(null));
        return "formulario-estudiantes";
    }

    @PostMapping("/estudiantes/save")
    public String equiposSaveProcess(@ModelAttribute("estudiantes") EstudianteDocument EstudianteDocument) {
        if (EstudianteDocument.getId().isEmpty()) {
            EstudianteDocument.setId(null);
        }
        EstudianteRepository.save(EstudianteDocument);
        return "redirect:/estudiantes/";
    }

    @GetMapping("/estudiantes/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        EstudianteRepository.deleteById(id);
        return "redirect:/estudiantes/";
    }
    
    @GetMapping("/informeestudiante")
    public String mostrarInformeGeneral(HttpSession session, Model model) {
        EstudianteDocument estudiante = (EstudianteDocument) session.getAttribute("estudiante");
        if (estudiante != null) {
            // Aquí puedes utilizar estudiante para personalizar la vista y datos del estudiante
            // Por ejemplo, cargar los datos del informe general específicos del estudiante
            List<informe> informeGeneral = obtenerInformeGeneralPorEstudiante(estudiante);
            if(informeGeneral != null && !informeGeneral.isEmpty()) {
            model.addAttribute("estudiante", estudiante);
            model.addAttribute("informe", informeGeneral);
            marcarInformeComoVisto(informeGeneral);
            }
            return "informeestudiantes"; // Crea una nueva vista para el informe general
        } else {
            return "redirect:/loginEstudiante";
        }
    }
    
    private void marcarInformeComoVisto(List<informe> informes) {
        for (informe informe : informes) {
            informe.setRevisado(true);
            informe.setDate(new Date()); // Establece la fecha y hora actual
            InformeRepository.save(informe);
        }
    }

    public List<informe> obtenerInformeGeneralPorEstudiante(EstudianteDocument estudiante) {
        return InformeRepository.findByEstudianteId(estudiante.getId());
    }
    
    @GetMapping("/Homeestudiante/")
    public String mostrarInicio(HttpSession session, Model model) {
        EstudianteDocument estudiante = (EstudianteDocument) session.getAttribute("estudiante");
        if (estudiante != null) {
            // Aquí puedes utilizar estudiante para personalizar la vista y datos del estudiante
            return "Homeestudiante";
        } else {
            return "redirect:/loginEstudiante";
        }
    }

    @GetMapping("/vermisdatos")
    public String mostrarMisDatos(HttpSession session, Model model) {
        EstudianteDocument estudiante = (EstudianteDocument) session.getAttribute("estudiante");
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante);
            return "datosestudiante";
        } else {
            return "redirect:/loginEstudiante";
        }
    }

    @PostMapping("/vermisdatos")
    public String actualizarMisDatos(@ModelAttribute EstudianteDocument estudiante, HttpSession session) {
    	EstudianteRepository.save(estudiante); // Actualiza los datos
        session.setAttribute("estudiante", estudiante); // Actualiza la información de la sesión
        return "redirect:/Homeestudiante/";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.removeAttribute("estudiante");
        return "redirect:/loginEstudiante";
    }

    // Otros métodos y rutas para la gestión de estudiantes

}
