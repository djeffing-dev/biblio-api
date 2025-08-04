package com.djeffing.biblio_app.repositories;

import com.djeffing.biblio_app.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
