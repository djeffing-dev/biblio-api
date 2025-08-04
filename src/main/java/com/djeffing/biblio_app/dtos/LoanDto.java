package com.djeffing.biblio_app.dtos;

import com.djeffing.biblio_app.Models.Book;
import com.djeffing.biblio_app.Models.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class LoanDto {
    private Long id;

    private Date dateEmprunt;
    private  Date dateRetourEstimer;
    private Date dateRetour;
    private Customer customer;
    private Book book;
}
