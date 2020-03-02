package com.picoulet.springdelamort.controllers;

import com.picoulet.springdelamort.models.Utilisateur;
import com.picoulet.springdelamort.repositories.RoleRepository;
import com.picoulet.springdelamort.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UtilisateurController {
    /**
     * Repository Utilisateur
     */
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Repository Role
     */
    @Autowired
    private RoleRepository roleRepository;

    //------------------------------------------------------------------------

    /**
     * Affiche la liste des utilisateurs
     *
     * @return une vue contenant la liste des utilisateurs
     */
    @GetMapping(value = "/utilisateurs")
    public ModelAndView showAll() {
        return new ModelAndView("utilisateurs/list")
                .addObject("utilisateurs", utilisateurRepository.findAll());
    }

    //------------------------------------------------------------------------

    /**
     * Affiche un formulaire pour la création d'un utilisateur
     *
     * @return Retourne la page de formulaire pour ajouter un utilisateur
     */
    @GetMapping(value = "/utilisateurs/ajouter")
    public ModelAndView addUtilisateursForm() {
        return new ModelAndView("utilisateurs/add")
                .addObject("utilisateur", new Utilisateur())
                .addObject("roles", roleRepository.findAll());
    }

    //------------------------------------------------------------------------

    /**
     * Ajoute un utilisateur
     *
     * @param utilisateur Utilisateur à créer
     * @return Redirection du visiteur vers la liste des utilisateurs
     */
    @PostMapping(value = "/utilisateurs/ajouter")
    public RedirectView addUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return new RedirectView("/utilisateurs");
    }

    //------------------------------------------------------------------------

    /**
     * Affiche un formulaire avec les informations de l'utilisateur passer en
     * paramètre
     *
     * @param id de l'utilisateur à affichier
     * @return Une vue contenant un formulaire pour modifier un utilisateur
     */
    @GetMapping(value = "/utilisateurs/{id}")
    public ModelAndView showUtilisateur(@PathVariable("id") Long id) {
        return new ModelAndView("utilisateurs/update")
                .addObject("utilisateur", utilisateurRepository.findUtilisateurByUtilisateurId(id))
                .addObject("roles", roleRepository.findAll());
    }

    //------------------------------------------------------------------------

    /**
     * Met à jour un utilisateur
     *
     * @param id          id de l'utilisateur à mettre à jour
     * @param utilisateur information de l'utilisateur à mettre à jours
     * @return Redirection du visiteur vers la liste des utilisateurs
     */
    @PostMapping(value = "/utilisateurs/{id}")
    public RedirectView updateUtilisateur(@PathVariable(value = "id") long id, Utilisateur utilisateur) {
        utilisateurRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Utilisateur: " + id + " n'existe pas.")
        );
        utilisateurRepository.save(utilisateur);
        return new RedirectView("/utilisateurs");
    }

    //------------------------------------------------------------------------

    /**
     * Supprime un utilisateur
     *
     * @param id de l'utilisateur
     * @return Redirection du visiteur vers la liste des utilisateurs
     */
    @GetMapping("/utilisateurs/supprimer/{id}")
    public RedirectView deleteUser(@PathVariable("id") long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Utilisateur: " + id + " n'existe pas.")
        );
        utilisateurRepository.delete(utilisateur);
        return new RedirectView("/utilisateurs");
    }
}
