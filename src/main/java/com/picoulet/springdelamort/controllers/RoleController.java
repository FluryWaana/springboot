package com.picoulet.springdelamort.controllers;

import com.picoulet.springdelamort.models.Role;
import com.picoulet.springdelamort.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    public ModelAndView showAll(HttpServletRequest request) {
        String error = (String) request.getSession().getAttribute("error");
        request.getSession().removeAttribute("error");
        return new ModelAndView("roles/list")
                .addObject("roles", roleRepository.findAll())
                .addObject("error", error);
    }

    //------------------------------------------------------------------------

    /**
     * Affiche un formulaire pour la création d'un role
     *
     * @return Retourne la page de formulaire pour ajouter un role
     */
    @GetMapping(value = "/roles/ajouter")
    public ModelAndView addRoleForm() {
        return new ModelAndView("roles/add")
                .addObject("role", new Role());
    }

    //------------------------------------------------------------------------

    /**
     * Ajoute un role
     *
     * @param role Role à créer
     * @return Redirection du visiteur vers la liste des roles
     */
    @PostMapping(value = "/roles/ajouter")
    public String addRole(@ModelAttribute("role") @Valid Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "roles/add";
        }
        roleRepository.save(role);
        return "redirect:/roles";
    }

    //------------------------------------------------------------------------

    /**
     * Affiche un formulaire avec les informations du role passer en
     * paramètre
     *
     * @param id id du role
     * @return Une vue contenant un formulaire pour modifier un role
     */
    @GetMapping(value = "/roles/{id}")
    public ModelAndView showRole(@PathVariable("id") Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Le role n'existe pas.")
        );

        return new ModelAndView("roles/update").addObject("role", role);
    }

    //------------------------------------------------------------------------

    @PostMapping(value = "/roles/{id}")
    public String updateRole(@PathVariable(value = "id") Long id, @Valid Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            role.setRoleId(id);
            return "roles/update";
        }

        roleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Le role n'existe pas.")
        );

        roleRepository.save(role);
        return "redirect:/roles";
    }

    //------------------------------------------------------------------------

    /**
     * Supprime un role
     *
     * @param
     * @return Redirection du visiteur vers la liste des utilisateurs
     */
    @GetMapping("/roles/supprimer/{id}")
    public String deleteUser(@PathVariable("id") Long id, HttpServletRequest request) {
        Role role = roleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Role: " + id + " n'existe pas.")
        );

        if (role.getUtilisateurs().size() == 0) {
            roleRepository.delete(role);
        } else {
            request.getSession().setAttribute("error", "Impossible de supprimer un rôle qui possède des utilisateurs");
        }
        return "redirect:/roles";
    }
}
