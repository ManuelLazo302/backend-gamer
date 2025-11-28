package com.example.productos.seeder;

import com.example.productos.model.User;
import com.example.productos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByNombre("admin").isEmpty()) {
            User admin = new User();
            admin.setNombre("Administrador");
            admin.setClave(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@levelup.com");
            admin.setAdmin(true);

            userRepository.save(admin);
        }
    }

}
