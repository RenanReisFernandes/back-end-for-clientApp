package com.renan.clientApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.renan.clientApp.Request.AuthRequest;
import com.renan.clientApp.Response.AuthResponse;
import com.renan.clientApp.config.JwtUtil;
import com.renan.clientApp.entities.Usuario;
import com.renan.clientApp.repositories.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.username(), request.password()
                )
            );
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = jwtUtil.gerarToken(user);
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        if (request.username() == null || request.password() == null) {
            return ResponseEntity.badRequest().body("Usuário e senha são obrigatórios.");
        }

        if (usuarioRepository.findByUsername(request.username()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(request.username());
        novoUsuario.setPassword(passwordEncoder.encode(request.password()));
        usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok("Usuário registrado com sucesso.");
    }
}
