package com.movenow.movenow.domain.category;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.movenow.movenow.domain.Category;

@Component
public class CategoryService {
	
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
	
	
    
    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategory(Long id) {
    	for (Category category : categories) {
    		if (category.getId() == id) {
    			return category;
    		}
		}
    	throw new NullPointerException();
    	 
    }
}
