package com.movenow.movenow.application;

import com.movenow.movenow.domain.Category;
import com.movenow.movenow.domain.MoveUser;
import com.movenow.movenow.domain.Skill;
import com.movenow.movenow.domain.UserCategory;
import com.movenow.movenow.domain.UserCategoryDTO;
import com.movenow.movenow.domain.UserCategoryRepository;
import com.movenow.movenow.domain.category.CategoryService;
import com.movenow.movenow.domain.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/userCategories")
public class UserCategoryController {
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	CategoryService categoryService;
	
    private final UserCategoryRepository userCategoryRepository;

    public UserCategoryController(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }
    
    @GetMapping
    public List<UserCategory> getUserCategories(@RequestParam Long userId) {
    		return userCategoryRepository.findByUserId(userId);    	
    }
    
    
    @PostMapping
    public ResponseEntity<UserCategory> create(@RequestBody UserCategory userCategory) throws URISyntaxException {   
	   var savedMove =  userCategoryRepository.save(userCategory);
       return ResponseEntity.created(new URI("/userCategories/" + savedMove.getId())).body(savedMove);
    }
    
    
    public UserCategoryDTO toDTO(UserCategory userCategory) {
    	UserCategoryDTO userCategoryDTO = new UserCategoryDTO(userCategory);
    	
    	if(userCategoryDTO.getCategoryId() != null) {
    		Category category = categoryService.getCategory(userCategory.getCategoryId());
    		userCategoryDTO.setCategoryName(category.getName());
    	}
    	
    	if(userCategoryDTO.getSkillId() != null) {
    		Skill skill = skillService.getSkill(userCategory.getSkillId());
    		userCategoryDTO.setSkillName(skill.getName());		
    	}
    	
    	return userCategoryDTO;    	
    }
}
