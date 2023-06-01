package com.example.revature.bookstore.services;

import com.example.revature.bookstore.DAO.Book;
import com.example.revature.bookstore.exceptions.BookStoreExceptions;
import com.example.revature.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService {
    private final BookRepository bookRepository;

    private final String invalidTitleMessage = "Invalid title, title was blank.";

    private final String resourceNotFoundMessage = "Resource was not found in DB";

    @Autowired
    public BookStoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
            isValidTitle(book);
            return bookRepository.save(book);
    }

    public Optional<Book> getBook(Long id){
        Optional<Book> result = bookRepository.findById(id);
        if(!result.isPresent()) throw new BookStoreExceptions(resourceNotFoundMessage);
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }

    // Since respository.save() is being used to update,
    // The id is checked to see if it already exists in DB.
    // This is because if it does not exist, then the save()
    // method will create a new entry.
    public Book updateBook(Book book){
        Optional<Book> bookInDB = getBook(book.getId());
        isValidTitle(book);

        if(!bookInDB.isPresent()) throw new BookStoreExceptions(resourceNotFoundMessage);

        return bookRepository.save(book);
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
        Optional<Book> result = getBook(book.getId());
        if(result.isPresent()) throw new BookStoreExceptions(resourceNotFoundMessage);
    }

    private boolean isValidTitle(Book book) {
        if (!book.getTitle().isBlank()) return true;
        else throw new IllegalArgumentException(invalidTitleMessage);
    }
}
