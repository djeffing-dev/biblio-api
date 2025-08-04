package com.djeffing.biblio_app.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String password;
}
