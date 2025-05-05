package com.renan.clientApp.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.renan.clientApp.entities.Usuario;

@Repository
public interface UsuarioRepository {

	Optional<Usuario> findByUsername(String username);

}
