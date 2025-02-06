package com.mati.techforbchallenge.controllers;

import com.mati.techforbchallenge.entities.Usuario;
import com.mati.techforbchallenge.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{email}")
    @Transactional()
    public Usuario findUserByEmail(@PathVariable String email) {
        return this.usuarioService.findByEmail(email);
    }

    @PostMapping
    @Transactional
    public Usuario createUser(@RequestBody Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateUser(@RequestBody Usuario usuario) {
        return this.usuarioService.updateUser(usuario);
    }

}
