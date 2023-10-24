package com.bibliotec.bibliotec.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping
    public void getAllBooks(){

    }

    @PostMapping
    public void createBooks(){

    }

    @PutMapping
    public void updateBook(){

    }

    @DeleteMapping
    public void deleteBook(){

    }
}
