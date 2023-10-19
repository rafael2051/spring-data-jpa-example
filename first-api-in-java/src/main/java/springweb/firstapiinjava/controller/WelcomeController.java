package springweb.firstapiinjava.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to my spring boot web api";
    }

    @GetMapping("/login/user")
    public String users(){
        return "Authorized user";
    }

    @GetMapping("/login/admin")
    public String MANAGERS(){
        return "Authorized manager";
    }
}
