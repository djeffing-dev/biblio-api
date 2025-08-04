package com.djeffing.biblio_app.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "Loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_emprunt")
    private Date dateEmprunt;
    @Column(name = "date_retour_estimer")
    private  Date dateRetourEstimer;
   @Column(name = "dateRetour")
    private Date dateRetour;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private  Customer customer;
   @ManyToOne
   @JoinColumn(name = "book_id")
   private Book book;

}
