package ru.anton.springinactionbootmvc.rest.simple.restcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//1 Case @Controller + @ResponseBody
//@Controller
//public class HelloController {
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello!";
//    }
//
//    @GetMapping("/goodbye")
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye!";
//    }
//}

//2 case - only @RequestController
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye!";
    }
}

