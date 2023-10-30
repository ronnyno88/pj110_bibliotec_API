package com.bibliotec.bibliotec.Services;

import com.bibliotec.bibliotec.DAO.CategoryDTO;
import com.bibliotec.bibliotec.Domains.Book;
import com.bibliotec.bibliotec.Domains.Category;
import com.bibliotec.bibliotec.Repositories.CategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getOneCategory(UUID id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(CategoryDTO categoryDto){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return categoryRepository.save(category);
    }

    public Category updateCategory(UUID id, CategoryDTO categoryDTO){
        Optional<Category> categoryO = categoryRepository.findById(id);
        if (categoryO.isPresent()) {
            var category = categoryO.get();
            BeanUtils.copyProperties(categoryDTO, category);
            return categoryRepository.save(category);
        }
        return null;
    }

    public void deleteCategory(UUID id){
        Optional<Category> categoryO = categoryRepository.findById(id);
        categoryO.ifPresent(categoryRepository::delete);
    }
}
