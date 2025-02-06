package com.mati.techforbchallenge.services;

import com.mati.techforbchallenge.entities.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    Usuario findByEmail(String email);
    Usuario save(Usuario usuario);
    ResponseEntity<?> updateUser(Usuario usuario);
}
