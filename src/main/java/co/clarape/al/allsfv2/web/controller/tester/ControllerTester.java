package co.clarape.al.allsfv2.web.controller.tester;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class ControllerTester {
    
    @GetMapping("/hola")
    public String Saludar() {
        return "Nunca pares de aprender!!!";
    }
}
