package com.picoulet.springdelamort.controllers;

import com.picoulet.springdelamort.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommandeController {
    /**
     * Repository Commande
     */
    @Autowired
    private CommandeRepository commandeRepository;

    //------------------------------------------------------------------------

    /**
     * Affiche la liste des commandes
     *
     * @return une vue contenant la liste des commandes
     */
    @GetMapping(value = "/commandes")
    public ModelAndView showAll() {
        return new ModelAndView("commandes/list")
                .addObject("commandes", commandeRepository.findAll());
    }
}
