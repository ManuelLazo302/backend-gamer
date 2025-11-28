package com.example.productos.controller;

import com.example.productos.security.jwt.*;
import com.example.productos.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserService userService;
    public AuthController(AuthenticationManager authManager, JwtService jwtService,
                          UserService userService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        if (username == null || password == null || username.isBlank() ||
                password.isBlank()) {
            throw new IllegalArgumentException("Username, password y correo son requeridos");
        }
        userService.register(username, password);
        return Map.of("message", "Usuario registrado correctamente");
    }
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        if (auth.isAuthenticated()) {
            String token = jwtService.generateToken(username);
            return Map.of("token", token);
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}
