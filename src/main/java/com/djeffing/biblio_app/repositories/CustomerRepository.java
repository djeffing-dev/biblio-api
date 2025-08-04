package com.djeffing.biblio_app.repositories;

import com.djeffing.biblio_app.Models.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE customers RESTART IDENTITY CASCADE", nativeQuery = true)
    void truncateTableAndResetId();
}
