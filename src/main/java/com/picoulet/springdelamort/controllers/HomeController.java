package com.picoulet.springdelamort.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    /**
     * Affiche la page principale du site
     *
     * @return une vue contenant ...
     */
    @GetMapping(value = "/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }
}
