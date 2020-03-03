package com.picoulet.springdelamort.controllers;

import com.picoulet.springdelamort.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {
    /**
     * Repository Article
     */
    @Autowired
    private ArticleRepository articleRepository;

    //------------------------------------------------------------------------

    /**
     * Affiche la liste des articles
     *
     * @return une vue contenant la liste des articles
     */
    @GetMapping(value = "/articles")
    public ModelAndView showAll() {
        return new ModelAndView("articles/list")
                .addObject("articles", articleRepository.findAll());
    }
}
