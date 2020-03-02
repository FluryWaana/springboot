package com.picoulet.springdelamort;

import com.github.javafaker.Faker;
import com.picoulet.springdelamort.models.Role;
import com.picoulet.springdelamort.models.Utilisateur;
import com.picoulet.springdelamort.repositories.RoleRepository;
import com.picoulet.springdelamort.repositories.UtilisateurRepository;
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
    public CommandLineRunner demo(RoleRepository roleRepository, UtilisateurRepository utilisateurRepository) {
        Faker faker = new Faker(new Locale("fr-FR"));

        return (args) -> {
            List<Role> roles = new ArrayList<>(Arrays.asList(
                                    new Role("administrateur"),
                                    new Role("utilisateur"))
                                );
            roleRepository.saveAll(roles);

            for(int i = 0; i < 20; i++)
            {
                utilisateurRepository.save(new Utilisateur(
                        faker.gameOfThrones().city(),
                        faker.pokemon().name(),
                        new Role("utilisateur")
                ));
            }

        };
    }
}