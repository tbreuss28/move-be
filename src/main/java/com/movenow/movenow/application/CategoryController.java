package com.movenow.movenow.application;

import com.movenow.movenow.domain.Category;
import com.movenow.movenow.domain.category.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
    	try {
    		return ResponseEntity.ok(categoryService.getCategory(id));
    	} catch(Exception e) {
            return ResponseEntity.notFound().build();
    	}        

    }
}
