package com.bibliotec.bibliotec.Services;

import com.bibliotec.bibliotec.DTO.BookDTO;
import com.bibliotec.bibliotec.Domains.Book;
import com.bibliotec.bibliotec.Domains.Category;
import com.bibliotec.bibliotec.Repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryService categoryService;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getOneBook(UUID id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(BookDTO bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);

        List<Category> categories = new ArrayList<>();
        for (UUID categoryId : bookDto.category_ids()) {
            Category category = categoryService.getOneCategory(categoryId).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
            categories.add(category);
        }

        book.setCategories(new HashSet<>(categories));
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
