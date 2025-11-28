package com.example.productos.service;

import com.example.productos.model.User;
import com.example.productos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(String nombre, String clave) {
        User user = User.builder()
                .nombre(nombre)
                .clave(passwordEncoder.encode(clave))
                .build();
        return userRepository.save(user);
    }
    public Optional<User> findByUsername(String nombre) {
        return userRepository.findByNombre(nombre);
    }
}



