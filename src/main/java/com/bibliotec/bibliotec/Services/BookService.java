package com.bibliotec.bibliotec.Services;

import com.bibliotec.bibliotec.DAO.BookDTO;
import com.bibliotec.bibliotec.Domains.Book;
import com.bibliotec.bibliotec.Repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getOneBook(UUID id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(BookDTO bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return bookRepository.save(book);
    }

    public Book updateBook(UUID id, BookDTO bookRecordDto) {
        Optional<Book> bookO = bookRepository.findById(id);
        if (bookO.isPresent()) {
            var book = bookO.get();
            BeanUtils.copyProperties(bookRecordDto, book);
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(UUID id) {
        Optional<Book> bookO = bookRepository.findById(id);
        bookO.ifPresent(bookRepository::delete);
    }
}
