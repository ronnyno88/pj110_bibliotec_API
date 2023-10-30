package com.bibliotec.bibliotec.Controllers;

import com.bibliotec.bibliotec.DAO.BookDTO;
import com.bibliotec.bibliotec.Domains.Book;
import com.bibliotec.bibliotec.Services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList = bookService.getAllBooks();
        //hateoas
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBooksById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getOneBook(id));
    }
    @PostMapping(value = "/books")
    public ResponseEntity<Book> createBooks(@RequestBody @Valid BookDTO bookDTO){
        //hateoas
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookDTO));
    }
    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable(value = "id") UUID id, @RequestBody @Valid BookDTO bookDTO){
        Book book = bookService.updateBook(id, bookDTO);
        if (book != null){
            //hateoas
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found!");
        }
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") UUID id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delected Sucessfully");
    }

}
