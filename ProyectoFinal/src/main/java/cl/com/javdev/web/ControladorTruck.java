package cl.com.javdev.web;

import cl.com.javdev.domain.Trucks;
import cl.com.javdev.service.TruckService;
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
public class ControladorTruck {
    @Autowired
    private TruckService truckService;

    @GetMapping("/trucks")
    public String listar2(Model model){
        var trucks = truckService.listarTrucks();
        model.addAttribute("trucks", trucks);
        return "index2";
    }
    @GetMapping("/agregar2")
    public String agregar2(Trucks truck){
        return "modificar2";
    }

    @PostMapping("/guardar2")
    public String guardarTruck(@Valid Trucks trucks, Errors errores){
        if(errores.hasErrors()){
            return "index2";
        }
        truckService.guardarTruck(trucks);
        return "redirect:/";
    }
    @GetMapping("/editar2/{idTrucks}")
    public String editar2(Trucks trucks, Model model){
        trucks = truckService.encontrarTruck(trucks);
        model.addAttribute("trucks", trucks);
        return "modificar2";
    }
    @GetMapping("/eliminar2")
    public String eliminar2(Trucks trucks){
        truckService.eliminar(trucks);
        return "redirect:/";
    }
}
