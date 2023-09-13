package cl.com.javdev.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AppController {
    @GetMapping("/")
    public String verPaginaInicio(@AuthenticationPrincipal User user) {
        log.info("Usuario que hizo Login: " + user);
        return "index1";
    }
}