package com.djeffing.biblio_app.repositories;

import com.djeffing.biblio_app.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
