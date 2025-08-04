package com.djeffing.biblio_app.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(name = "nbr_diponible")
    private Integer nbrDiponible;

    @Column(name = "nbr_total")
    private Integer nbrTotal;


}
