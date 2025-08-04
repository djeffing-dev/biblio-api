package com.djeffing.biblio_app.repositories;

import com.djeffing.biblio_app.Models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE users RESTART IDENTITY CASCADE", nativeQuery = true)
    void truncateTableAndResetId();
}
