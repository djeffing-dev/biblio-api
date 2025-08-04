package com.djeffing.biblio_app.repositories;

import com.djeffing.biblio_app.Models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE books RESTART IDENTITY CASCADE", nativeQuery = true)
    void truncateTableAndResetId();
}
