package com.djeffing.biblio_app.services.interfaces;

import com.djeffing.biblio_app.dtos.BookDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDto create(BookDto bookDto);
    List<BookDto> findAll();
    Optional<BookDto> findById(long bookId);
    BookDto update(long boobId, BookDto bookDto);

    String deleteById(long booId);

    String deleteAll();
}
