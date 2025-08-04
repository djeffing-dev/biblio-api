package com.djeffing.biblio_app.databases;

import com.djeffing.biblio_app.dtos.BookDto;
import com.djeffing.biblio_app.services.interfaces.BookService;
import org.springframework.stereotype.Component;

@Component
public class BookCommand {
    final  private BookService bookService;

    public BookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    public void save(){
        bookService.deleteAll();
        BookDto book1 = BookDto.builder()
                .title("Le Petit Prince")
                .nbrDiponible(3)
                .nbrTotal(5)
                .build();

        BookDto book2 = BookDto.builder()
                .title("L'Étranger")
                .nbrDiponible(2)
                .nbrTotal(4)
                .build();

        BookDto book3 = BookDto.builder()
                .title("1984")
                .nbrDiponible(5)
                .nbrTotal(5)
                .build();

        BookDto book4 = BookDto.builder()
                .title("Les Misérables")
                .nbrDiponible(1)
                .nbrTotal(3)
                .build();
        BookDto book5 = BookDto.builder()
                .title("Harry Potter à l'école des sorciers")
                .nbrDiponible(4)
                .nbrTotal(6)
                .build();

        bookService.create(book1);
        bookService.create(book2);
        bookService.create(book3);
        bookService.create(book4);
        bookService.create(book5);
    }


}

