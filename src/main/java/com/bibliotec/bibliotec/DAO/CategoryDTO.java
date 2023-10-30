package com.bibliotec.bibliotec.DAO;

import com.bibliotec.bibliotec.Domains.Category;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {
    private Integer id;
    private String description;
    public CategoryDTO(Category obj) {
        //this.id = obj.getId();
        this.description = obj.getDescription();
    }
}
