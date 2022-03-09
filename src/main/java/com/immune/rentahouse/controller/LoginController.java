package com.immune.rentahouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    
    @GetMapping("/login")
    public ModelAndView login() {

        ModelAndView model = new ModelAndView("index");
        try {
            System.out.println(model.getViewName());
            return model;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ModelAndView("error");
        }


    }

}
