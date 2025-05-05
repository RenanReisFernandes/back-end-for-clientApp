package com.renan.clientApp.services;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.renan.clientApp.entities.Usuario;
import com.renan.clientApp.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new User(usuario.getUsername(), usuario.getPassword(), List.of());
    }
}
