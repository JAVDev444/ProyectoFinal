package cl.com.javdev.web;

import cl.com.javdev.domain.Driver;
import cl.com.javdev.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/api/v1/drivers")
public class ControladorDri {
    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    public String inicio(Model model) {
        var drivers = driverService.listarDrivers();
        model.addAttribute("drivers", drivers);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Driver driver) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Driver driver, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        driverService.guardar(driver);
        return "redirect:/";
    }

    @GetMapping("/editar/{idDrivers}")
    public String editar(Driver driver, Model model) {
        driver = driverService.encontrarDriver(driver);
        model.addAttribute("driver", driver);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Driver driver) {
        driverService.eliminar(driver);
        return "redirect:/";
    }

}
