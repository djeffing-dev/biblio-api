package com.djeffing.biblio_app.repositories;

import com.djeffing.biblio_app.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
