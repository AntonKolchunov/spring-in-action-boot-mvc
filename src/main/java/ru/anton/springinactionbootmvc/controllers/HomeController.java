package ru.anton.springinactionbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/home/{color}")
    public String home(@PathVariable("color") String color,
                       @RequestParam(required = false, defaultValue = "Katy") String name,
                       Model model) {
        model.addAttribute("username", name);
        model.addAttribute("color", color);
        return "home.html";
    }
}
