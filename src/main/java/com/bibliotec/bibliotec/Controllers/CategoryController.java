package com.bibliotec.bibliotec.Controllers;

import com.bibliotec.bibliotec.DTO.CategoryDTO;
import com.bibliotec.bibliotec.Domains.Category;
import com.bibliotec.bibliotec.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList = categoryService.getAllCategories();
        //hateoas
        return ResponseEntity.status(HttpStatus.OK).body(categoryList);
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<Object> getCategoriesById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getOneCategory(id));
    }


    @PostMapping(value = "/categories")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryDTO categoryDTO){
        //hateoas
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(categoryDTO));
    }

    @PutMapping(value = "/categories/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable(value = "id") UUID id, @RequestBody @Valid CategoryDTO categoryDTO){
        Category category = categoryService.updateCategory(id, categoryDTO);
        if (category != null){
            //hateoas
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }

    @DeleteMapping(value = "/categories/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable(value = "id") UUID id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delected sucessfully");
    }


}
