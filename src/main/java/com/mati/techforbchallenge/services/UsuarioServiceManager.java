package com.mati.techforbchallenge.services;

import com.mati.techforbchallenge.entities.Usuario;
import com.mati.techforbchallenge.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceManager implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public ResponseEntity<?> updateUser(Usuario usuario) {
        Usuario usuarioAux = this.usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioAux == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
        boolean isUpdated = false;
        if (!usuario.getNombreUsuario().equals(usuarioAux.getNombreUsuario())) {
            usuarioAux.setNombreUsuario(usuario.getNombreUsuario());
            isUpdated = true;
        }
        if (!usuario.getContrasena().equals(usuarioAux.getContrasena())) {
            usuarioAux.setContrasena(usuario.getContrasena());
            isUpdated = true;
        }

        if (isUpdated) {
            usuarioRepository.save(usuarioAux);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("No hubo cambios en el usuario");
        }

    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {

        Usuario usuario = this.usuarioRepository.findById(id).get();

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
        usuarioRepository.delete(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado correctamente");

    }


}
