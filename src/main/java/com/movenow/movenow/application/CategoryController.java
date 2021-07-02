package com.movenow.movenow.application;

import com.movenow.movenow.domain.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    private List<Category> categories = new ArrayList<>();

    @PostConstruct
    private void postConstruct() {
        categories.add(new Category() {{
            setId(1L);
            setName("Fußball");
        }});
        categories.add(new Category() {{
            setId(2L);
            setName("Tennis");
        }});
        categories.add(new Category() {{
            setId(3L);
            setName("Laufen");
        }});
    }
    
    @GetMapping
    public List<Category> getCategories() {
        return categories;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable Long id) {
        for (Category category:
             categories) {
            if (category.getId() == id) {
                return ResponseEntity.ok(category);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
