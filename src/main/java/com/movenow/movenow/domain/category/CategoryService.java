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
            setName("American Football");
        }});
        categories.add(new Category() {{
            setId(2L);
            setName("Badminton");
        }});
        categories.add(new Category() {{
            setId(3L);
            setName("Baseball");
        }});
        categories.add(new Category() {{
            setId(4L);
            setName("Billard");
        }});
        categories.add(new Category() {{
            setId(5L);
            setName("Boxen");
        }});
        categories.add(new Category() {{
            setId(6L);
            setName("Basketball");
        }});
        categories.add(new Category() {{
            setId(7L);
            setName("Dart");
        }});
        categories.add(new Category() {{
            setId(8L);
            setName("Eishockey");
        }});
        categories.add(new Category() {{
            setId(9L);
            setName("Esports");
        }});
        categories.add(new Category() {{
            setId(10L);
            setName("Fußball");
        }});
        categories.add(new Category() {{
            setId(11L);
            setName("Golf");
        }});
        categories.add(new Category() {{
            setId(12L);
            setName("Laufen");
        }});
        categories.add(new Category() {{
            setId(13L);
            setName("Radfahren");
        }});
        categories.add(new Category() {{
            setId(14L);
            setName("Segeln");
        }});
        categories.add(new Category() {{
            setId(15L);
            setName("Squash");
        }});
        categories.add(new Category() {{
            setId(16L);
            setName("Schifahren");
        }});
        categories.add(new Category() {{
            setId(17L);
            setName("Snowboarden");
        }});
        categories.add(new Category() {{
            setId(18L);
            setName("Tischtennis");
        }});
        categories.add(new Category() {{
            setId(19L);
            setName("Turnen");
        }});
        categories.add(new Category() {{
            setId(20L);
            setName("Tanzen");
        }});
        categories.add(new Category() {{
            setId(21L);
            setName("Tennis");
        }});
        categories.add(new Category() {{
            setId(22L);
            setName("Volleyball");
        }});
        categories.add(new Category() {{
            setId(23L);
            setName("Wing Tsun");
        }});
        categories.add(new Category() {{
            setId(24L);
            setName("Yoga");
        }});
        categories.add(new Category() {{
            setId(25L);
            setName("Zumba");
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
