package com.picoulet.springdelamort.repositories;

import com.picoulet.springdelamort.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
