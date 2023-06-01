package com.example.revature.bookstore.controllers;

import com.example.revature.bookstore.DAO.Book;
import com.example.revature.bookstore.services.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookStoreController {
    private BookStoreService bookStoreService;

    @Autowired
    public void setBookStoreService(BookStoreService bookStoreService){
        this.bookStoreService = bookStoreService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> addBookToStore(@RequestBody Book book) {
            return ResponseEntity.ok().body(bookStoreService.addBook(book));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> getAllBooks(@RequestBody Book book){
        List<Book> result = bookStoreService.getAllBooks();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<Book> getBook(@RequestParam Long id){
//        try {
//            Optional<Book> result = bookStoreService.getBook(id);
//            if (result.isPresent()) return ResponseEntity.ok().body(result.get());
//            else return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//        } catch (Exception e){
//            System.out.println(e);
//            return ResponseEntity.internalServerError().body(null);
//        }
        Optional<Book> result = bookStoreService.getBook(id);
        return ResponseEntity.ok().body(result.get());
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
//        try {
//            if(book.getId() == null) return ResponseEntity.badRequest().body(book);
//
//            Book result = bookStoreService.updateBook(book);
//            if (result.getId() == book.getId()) return ResponseEntity.ok().body(result);
//            else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(book);
//        }
//        catch (Exception e){
//            System.out.println(e);
//            return ResponseEntity.internalServerError().body(null);
//        }
        Book result = bookStoreService.updateBook(book);
        return ResponseEntity.ok().body(result);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@RequestBody Book book){
//        try{
//            Boolean successfullyDeleted = bookStoreService.deleteBook(book);
//            if (successfullyDeleted) return ResponseEntity.ok().body(new Book());
//            else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(book);
//        }
//        catch (Exception e) {
//            return ResponseEntity.internalServerError().body(null);
//        }

        bookStoreService.deleteBook(book);
        return ResponseEntity.ok().body("Successfully deleted.");
    }
}
