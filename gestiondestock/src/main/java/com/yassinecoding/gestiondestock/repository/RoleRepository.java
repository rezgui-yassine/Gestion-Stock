package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository< Roles , Integer> {
}
