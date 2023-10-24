package com.bibliotec.bibliotec.Repositories;

import com.bibliotec.bibliotec.Domains.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
