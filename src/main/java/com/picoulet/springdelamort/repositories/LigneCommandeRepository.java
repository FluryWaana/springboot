package com.picoulet.springdelamort.repositories;

import com.picoulet.springdelamort.models.LigneCommande;
import com.picoulet.springdelamort.models.LigneCommandeCK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandeCK> {
}
