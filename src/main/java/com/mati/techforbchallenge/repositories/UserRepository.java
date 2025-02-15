package com.mati.techforbchallenge.repositories;

import java.util.Optional;

import com.mati.techforbchallenge.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsername(String username);
}
