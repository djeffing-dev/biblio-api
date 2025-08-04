package com.djeffing.biblio_app.services.imp;

import com.djeffing.biblio_app.Models.Book;
import com.djeffing.biblio_app.dtos.BookDto;
import com.djeffing.biblio_app.mappers.BookMapper;
import com.djeffing.biblio_app.repositories.BookRepository;
import com.djeffing.biblio_app.services.interfaces.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BooKServiceImp implements BookService {
    final  private BookRepository bookRepository;
    final  private BookMapper bookMapper;

    public BooKServiceImp(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    private  BookDto save(BookDto bookDto){
        Book book = bookMapper.toBooK(bookDto);
        Book bookSaved =  bookRepository.save(book);
        return bookMapper.toBookDto(bookSaved);
    }
    @Override
    public BookDto create(BookDto bookDto) {
        return save(bookDto);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDto> findById(long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        return bookOptional.map(book -> BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .nbrDiponible(book.getNbrDiponible())
                .nbrTotal(book.getNbrTotal())
                .build());
    }

    @Override
    public BookDto update(long boobId, BookDto bookDto) {
        Optional<BookDto> bookDtoOptional = findById(boobId);
        if(bookDtoOptional.isPresent()){
            BookDto  newBookDto = bookDtoOptional.get();
            if(bookDto.getTitle()!=null){
                newBookDto.setTitle(bookDto.getTitle());
            }

            if(bookDto.getNbrDiponible() != null){
                newBookDto.setNbrDiponible(bookDto.getNbrDiponible());
            }

            if(bookDto.getNbrTotal() != null){
                newBookDto.setNbrTotal(bookDto.getNbrTotal());
            }

            return save(newBookDto);

        }
        return null;
    }

    @Override
    public String deleteById(long booId) {
        bookRepository.deleteById(booId);
        return "Votre livre a été supprimer avec succès";
    }

    @Override
    public String deleteAll() {
        bookRepository.deleteAll();
        return "La liste des livres à été supprimer avec succès";
    }
}
