package com.example.SpringBootL.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {


    @GetMapping
    public String getHomePage()
    {
        return "welcome to home page";
    }
    @GetMapping("/dashboard")
    public String getDasbhboardPage()
    {
        return "Login Succesfull";
    }
}
