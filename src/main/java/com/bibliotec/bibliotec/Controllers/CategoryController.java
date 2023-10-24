package com.bibliotec.bibliotec.Controllers;

import com.bibliotec.bibliotec.DAO.CategoryDTO;
import com.bibliotec.bibliotec.Domains.Category;
import com.bibliotec.bibliotec.Repositories.CategoryRepository;
import com.bibliotec.bibliotec.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<Category> categories = service.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(CategoryDTO::new).toList();
        return ResponseEntity.ok(categoryDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategoriesById(@PathVariable Integer id){
        Category obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }


    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO objDTO){
        Category newObj = service.update(id, objDTO);
        return ResponseEntity.ok(new CategoryDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
