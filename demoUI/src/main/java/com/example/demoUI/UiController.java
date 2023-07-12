package com.example.demoUI;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class UiController {


    @RequestMapping("/call")
    public String getWelcome(Model model){
    model.addAttribute("name","Abhinash");
    return "index";
    }
}
