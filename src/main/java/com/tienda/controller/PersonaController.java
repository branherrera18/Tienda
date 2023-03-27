package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/persona")
    public String index(Model model){
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo","Tabla Personas");
        model.addAttribute("persona",listaPersona);
        return "personas";
    }
    
    @GetMapping("/personaN")
    public String crearPersona(Model model){
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona",new Persona());//"persona"-> como lo leemos en el html //envia el objeto al html
        model.addAttribute("paises",listaPaises);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona){
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.savePersona(persona);
        return "redirect:/persona";
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model){
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona",persona);
        model.addAttribute("paises",listaPaises);
        return "crear";
    }   
    
    @RequestMapping(path = {"/search"})
    public String home(Persona persona, Model model, String keyword){
        if(keyword!=null){
            List<Persona> listaPersonas = personaService.getByKeyword(keyword);
            model.addAttribute("persona",listaPersonas);
        }else{
            List<Persona> listaPersonas  = personaService.getAllPersona();
            model.addAttribute("persona",listaPersonas);
            return "personas";
        }
        return "personas";
      
    }
    
}
