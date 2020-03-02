package com.picoulet.springdelamort.controllers;

import com.picoulet.springdelamort.models.Role;
import com.picoulet.springdelamort.models.Utilisateur;
import com.picoulet.springdelamort.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RoleController {
    /**
     * Repository Role
     */
    @Autowired
    private RoleRepository roleRepository;

    //------------------------------------------------------------------------

    /**
     * Affiche la liste des roles
     *
     * @return une vue contenant la liste des roles
     */
    @GetMapping(value = "/roles")
    public ModelAndView showAll() {
        return new ModelAndView("roles/list")
                .addObject("roles", roleRepository.findAll());
    }

    //------------------------------------------------------------------------

    /**
     * Supprime un role
     *
     * @param
     * @return Redirection du visiteur vers la liste des utilisateurs
     */
    @GetMapping("/utilisateurs/supprimer/{role}")
    public RedirectView deleteUser(@PathVariable("role") String role_nom) {
        Role role = roleRepository.findById(role_nom).orElseThrow(() ->
                new IllegalArgumentException("Role: " + role_nom + " n'existe pas.")
        );
        roleRepository.delete(role);
        return new RedirectView("/utilisateurs");
    }
}
