package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/form")
    public String form(@RequestParam(name="nazwisko", required = false, defaultValue = "") String nazwisko,
                       @RequestParam(name="wiek", required = false, defaultValue = "") String wiek,
                       @RequestParam(name="panstwo", required = false, defaultValue = "") String panstwo,
                       @RequestParam(name="adres", required = false, defaultValue = "") String adres,
                       @RequestParam(name="check", required = false, defaultValue = "") String[] check,
                       @RequestParam(name="zaplata", required = false, defaultValue = "") String zaplata,
                       Model model
                        ){

        String languages = "";
        for (String temp : check){
            if (!temp.matches("")){
                languages = languages.concat(temp).concat(", ");
            }
        }
        if (languages.length() > 0){
            languages = languages.trim();
            languages = languages.substring(0, languages.length()-1);
        }

        model.addAttribute("nazwisko", nazwisko);
        model.addAttribute("wiek", wiek);
        model.addAttribute("panstwo", panstwo);
        model.addAttribute("adres", adres);
        model.addAttribute("check", languages);
        model.addAttribute("zaplata", zaplata);




        return "form";
    }
}
