package ru.anton.springinactionbootmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.anton.springinactionbootmvc.models.LoginProcessor;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    @Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam("username") String name,
                            @RequestParam("password") String password,
                            Model model) {
        loginProcessor.setUserName(name);
        loginProcessor.setPassword(password);

        boolean loginReslt = loginProcessor.login();
        if (loginReslt == true) {
            return "redirect:/main";
            //model.addAttribute("message", "You are now logged in");
        }
        else {
            model.addAttribute("message", "Login failed");
        }

        return "login.html";
    }
}
