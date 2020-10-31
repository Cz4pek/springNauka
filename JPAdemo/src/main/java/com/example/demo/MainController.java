package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PoeciWspanialiRepository poeciWspanialiRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewPoeta (@RequestParam String imie, @RequestParam String nazwisko, @RequestParam String ocena){
        PoeciWspaniali poeta = new PoeciWspaniali();
        poeta.setImie(imie);
        poeta.setNazwisko(nazwisko);
        poeta.setOcena(ocena);
        poeciWspanialiRepository.save(poeta);
        return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<PoeciWspaniali> getAllPoeci (){
        return poeciWspanialiRepository.findAll();
    }
}
