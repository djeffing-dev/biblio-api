package com.djeffing.biblio_app.controllers;

import com.djeffing.biblio_app.dtos.BookDto;
import com.djeffing.biblio_app.services.interfaces.BookService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    final  private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookDto create(@RequestBody BookDto bookDto){
        return  bookService.create(bookDto);
    }

    @GetMapping
    public List<BookDto> findAll(){
        return bookService.findAll();
    }

    @PutMapping("/update")
    public  BookDto update(@RequestParam long id,@RequestBody BookDto bookDto){
        return  bookService.update(id, bookDto);
    }

    @GetMapping("/findById")
    public Optional<BookDto> findById(@RequestParam long id){
        return  bookService.findById(id);
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam long id){
        return  bookService.deleteById(id);
    }

}
