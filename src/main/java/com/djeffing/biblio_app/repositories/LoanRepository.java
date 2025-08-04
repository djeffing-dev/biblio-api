package com.djeffing.biblio_app.repositories;

import com.djeffing.biblio_app.Models.Loan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE loans RESTART IDENTITY CASCADE", nativeQuery = true)
    void truncateTableAndResetId();
}
