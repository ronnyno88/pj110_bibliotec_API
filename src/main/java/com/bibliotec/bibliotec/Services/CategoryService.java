package com.bibliotec.bibliotec.Services;

import com.bibliotec.bibliotec.DAO.CategoryDTO;
import com.bibliotec.bibliotec.Domains.Category;
import com.bibliotec.bibliotec.Repositories.CategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public Category findById(Integer id){
        Optional<Category> obj = repository.findById(id);
        return null;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category create(Category obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Category update(Integer id, CategoryDTO objDTO){
        Category obj = findById(id);
        if(obj != null){
            obj.setId(objDTO.getId());
            obj.setDescription(objDTO.getDescription());
            return repository.save(obj);
        }
        return null;
    }

    public void deleteById(Integer id){
        findById(id);
        repository.deleteById(id);
    }
}
