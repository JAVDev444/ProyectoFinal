package cl.com.javdev.web;


import cl.com.javdev.domain.Packages;
import cl.com.javdev.service.PackageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class ControladorPackages {
    @Autowired
    private PackageService packageService;

    @GetMapping("/packages")
    public String inicio(Model model) {
        var packages = packageService.listarPackages();
        model.addAttribute("packages", packages);
        return "index3";
    }
    @GetMapping("/agregar3")
    public String agregar3(Packages packages){
        return "modificar3";
    }
    @PostMapping("/guardar3")
    public String guarda3(@Valid Packages packages, Errors errores){
        if(errores.hasErrors()){
            return "modificar3";
        }
        packageService.guardarPackages(packages);
        return "redirect:/";
    }
    @GetMapping("/editar3/{idPackages}")
    public String editar3(Packages packages, Model model){
        packages =packageService.encontrarPackages(packages);
        model.addAttribute("packages", packages);
        return "modificar3";
    }
    @GetMapping("/eliminarp")
    public String eliminarpackages(Packages packages){
        packageService.eliminarPackages(packages);
        return "redirect:/";
    }
}