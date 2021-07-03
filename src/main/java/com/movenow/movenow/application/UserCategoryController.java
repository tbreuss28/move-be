package com.movenow.movenow.application;

import com.movenow.movenow.domain.UserCategory;
import com.movenow.movenow.domain.UserCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/userCategories")
public class UserCategoryController {
    private final UserCategoryRepository userCategoryRepository;

    public UserCategoryController(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }

    @GetMapping
    public List<UserCategory> getUserCategories() {
        return userCategoryRepository.findAll();
    }
}
