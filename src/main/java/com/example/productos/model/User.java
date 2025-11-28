package com.example.productos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String clave;
    @Column(nullable = false)
    private String email;
    private boolean isAdmin;
}
