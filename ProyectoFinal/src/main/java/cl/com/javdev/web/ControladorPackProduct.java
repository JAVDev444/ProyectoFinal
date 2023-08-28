package cl.com.javdev.web;

import cl.com.javdev.domain.Package_Products;
import cl.com.javdev.service.PackProductService;
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
public class ControladorPackProduct {
    @Autowired
    private PackProductService packProductService;

    @GetMapping("/packprod")
    public String inicio(Model model){
        var packpro = packProductService.listarPackProduct();
        model.addAttribute("packpro", packpro);
        return "index4";
    }
    @GetMapping("/agregar4")
    public String agregar4(Package_Products package_Products){
        return "modificar4";
    }
    @PostMapping("/guardar4")
    public String guardar4(@Valid Package_Products packpro, Errors errores){
        if(errores.hasErrors()){
            return "modificar4";
        }
        packProductService.guardarPackProduct(packpro);
        return "redirect:/";
    }
    @GetMapping("/editar4/{idProducts}")
    public String editar4(Package_Products package_Products, Model model){
       package_Products = packProductService.encontrarPackProduct(package_Products);
        model.addAttribute("package_Products", package_Products);
        return "modificar4";
    }
    @GetMapping("/eliminar4")
    public String eliminar4(Package_Products packpro){
        packProductService.eliminarPackProduct(packpro);
        return "redirect:/";
    }
}
