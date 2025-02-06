package com.mati.techforbchallenge.repositories;


import com.mati.techforbchallenge.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {


    Usuario findByEmail(String email);

}
