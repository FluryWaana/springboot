package com.picoulet.springdelamort;

import com.github.javafaker.Faker;
import com.picoulet.springdelamort.models.*;
import com.picoulet.springdelamort.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class SpringdelamortApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdelamortApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(RoleRepository roleRepository,
                                  UtilisateurRepository utilisateurRepository,
                                  ArticleRepository articleRepository,
                                  CommandeRepository commandeRepository,
                                  LigneCommandeRepository ligneCommandeRepository
    ) {
        Faker faker = new Faker(new Locale("fr-FR"));

        return (args) -> {
            /**
             * Création des utilisateurs
             */
            Role role = roleRepository.save(new Role("utilisateur"));
            for (int i = 0; i < 20; i++) {

                Utilisateur utilisateur = utilisateurRepository.save(new Utilisateur(
                        faker.gameOfThrones().city(),
                        faker.pokemon().name(),
                        role
                ));

                /**
                 * Création des commandes pour un utilisateur
                 */
                for (int a = 0; a < 6; a++) {
                    Commande commande = commandeRepository.save(new Commande(utilisateur));
                    createArticleByCommande(faker, commande, articleRepository, ligneCommandeRepository);
                }
            }
        };
    }

    /**
     * Créer une liste d'article
     * @param faker
     * @param commande
     * @return
     */
    private void createArticleByCommande(Faker faker, Commande commande,
                                                  ArticleRepository articleRepository,
                                                  LigneCommandeRepository ligneCommandeRepository
    ) {
        for (int i = 0; i < 15; i++) {
            Article article = articleRepository.save( new Article(faker.commerce().productName(),
                    faker.lorem().paragraph(300),
                    new Double(faker.number().numberBetween(20, 369))
            ));

            ligneCommandeRepository.save(new LigneCommande(
                    new LigneCommandeCK(commande.getCommandeReference(), article.getArticleReference()),
                    faker.number().numberBetween(2, 6)));
        }

    }
}