package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.LinkedList;


@Controller
public class FormController {

    @Autowired
    private FormDataRepository formDataRepository;

    @PostMapping(path = "/form")
    public void addNewFormData (@RequestParam(name="nazwisko", required = false, defaultValue = "") String nazwisko,
                           @RequestParam(name="wiek", required = false, defaultValue = "") String wiek,
                           @RequestParam(name="panstwo", required = false, defaultValue = "") String panstwo,
                           @RequestParam(name="adres", required = false, defaultValue = "") String adres,
                           @RequestParam(name="check", required = false, defaultValue = "") String[] check,
                           @RequestParam(name="zaplata", required = false, defaultValue = "") String zaplata,
                           Model model){

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

        FormData form = new FormData();
        form.setLasta_name(nazwisko);
        form.setAge(Integer.parseInt(wiek));
        form.setCountry(panstwo);
        form.setEmail(adres);
        form.setTech(languages);
        form.setPayment(zaplata);
        formDataRepository.save(form);
    }

    @GetMapping(path = "form")
    public String getAllRecords (Model model){
        Iterable<FormData> data = formDataRepository.findAll();
        LinkedList<String> records = new LinkedList<>();
        for (FormData temp: data) {
            StringBuilder s = new StringBuilder();
            s.append(temp.getId());
            s.append(" ");
            s.append(temp.getLasta_name());
            s.append(" ");
            s.append(temp.getAge());
            s.append(" ");
            s.append(temp.getCountry());
            s.append(" ");
            s.append(temp.getEmail());
            s.append(" ");
            s.append(temp.getTech());
            s.append(" ");
            s.append(temp.getPayment());
            s.append(" ");
            records.add(s.toString());
        }
        Object[] arr = records.toArray();
        model.addAttribute("records", arr);
        return "form";
    }

//    @GetMapping("/form")
//    public String form(){
//        return "form";
//    }
}
