package com.movenow.movenow.application;

import com.movenow.movenow.domain.Move;
import com.movenow.movenow.domain.MoveRepository;
import com.movenow.movenow.domain.User;
import com.movenow.movenow.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException {
        var savedMove = userRepository.save(user);
        return ResponseEntity.created(new URI("/users/" + savedMove.getId())).body(savedMove);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        var currentMove = userRepository.findById(id).orElseThrow(RuntimeException::new);
        currentMove.setFirstName(user.getFirstName());
        currentMove.setLastName(user.getLastName());
        currentMove.setUserName(user.getUserName());
        currentMove = userRepository.save(user);

        return ResponseEntity.ok(currentMove);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
