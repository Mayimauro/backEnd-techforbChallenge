package com.mati.techforbchallenge.entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsername(String username);
}
