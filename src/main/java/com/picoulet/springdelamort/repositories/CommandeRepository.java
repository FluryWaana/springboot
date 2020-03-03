package com.picoulet.springdelamort.repositories;

import com.picoulet.springdelamort.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
