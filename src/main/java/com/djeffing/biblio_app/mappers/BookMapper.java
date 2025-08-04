package com.djeffing.biblio_app.mappers;

import com.djeffing.biblio_app.Models.Book;
import com.djeffing.biblio_app.dtos.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toBookDto(Book book);
    Book toBooK(BookDto bookDto);
}
