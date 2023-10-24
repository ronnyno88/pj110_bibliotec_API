package com.bibliotec.bibliotec.Repositories;

import com.bibliotec.bibliotec.Domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
