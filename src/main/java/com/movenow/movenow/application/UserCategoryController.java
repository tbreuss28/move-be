package com.movenow.movenow.application;

import com.movenow.movenow.domain.User;
import com.movenow.movenow.domain.UserCategory;
import com.movenow.movenow.domain.UserCategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/userCategories")
public class UserCategoryController {
    private final UserCategoryRepository userCategoryRepository;

    public UserCategoryController(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }

    @GetMapping()
    public List<UserCategory> getUserCategories(@RequestParam Long userId) {
        return userCategoryRepository.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity createUserCategory(@RequestBody UserCategory userCategory) throws URISyntaxException {
        var savedUserCategory = userCategoryRepository.save(userCategory);
        return ResponseEntity.created(new URI("/userCategories/" + savedUserCategory.getId())).body(savedUserCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserCategory userCategory) {
        var currentUserCategory = userCategoryRepository.findById(id).orElseThrow(RuntimeException::new);
        currentUserCategory.setUser(userCategory.getUser());
        currentUserCategory.setCategory(userCategory.getCategory());
        currentUserCategory.setSkill(userCategory.getSkill());
        currentUserCategory = userCategoryRepository.save(userCategory);

        return ResponseEntity.ok(currentUserCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userCategoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
