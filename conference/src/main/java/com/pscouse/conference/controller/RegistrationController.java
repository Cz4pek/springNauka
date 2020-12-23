package com.pscouse.conference.controller;


import com.pscouse.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {


    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){ // specifying model as on object on Registration class and naming it registration

        return "registration";
    }
    @PostMapping("registration")
    public String addRegistration(@ModelAttribute("registration")Registration registration){
        System.out.println("Registration: " + registration.getName());
        return "registration";
    }
}
