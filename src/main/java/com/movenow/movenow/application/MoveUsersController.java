package com.movenow.movenow.application;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movenow.movenow.domain.MoveUser;
import com.movenow.movenow.domain.MoveUsersRepository;

@RestController
@RequestMapping("/api/moveUsers")
public class MoveUsersController {
	
	 private final MoveUsersRepository moveUsersRepository;


	   public MoveUsersController(MoveUsersRepository moveUsersRepository) {
	       this.moveUsersRepository = moveUsersRepository;
	   }
	   
	   
	   @GetMapping
	   public List<MoveUser> all() {
	    	List<MoveUser> moveUsers = moveUsersRepository.findAll();
	    	return moveUsers;
	   }
	   
	   @DeleteMapping("/{id}")
	    public ResponseEntity<MoveUser> delete(@PathVariable Long id) {
		   moveUsersRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	   }
	  
	   
	       
	   @GetMapping("/{id}")
	   public ResponseEntity<MoveUser> one(@PathVariable Long id) {
		   MoveUser moveUser = moveUsersRepository.findById(id).orElseThrow(RuntimeException::new);
		   if(moveUser != null) {
			   return ResponseEntity.ok(moveUser);	   
		   } else {
			   return ResponseEntity.notFound().build();
		   }
	   }
	   
	   @PostMapping
	    public ResponseEntity<MoveUser> create(@RequestBody MoveUser moveUser) throws URISyntaxException {   
		   var savedMove =  moveUsersRepository.save(moveUser);
	       return ResponseEntity.created(new URI("/moveUsers/" + savedMove.getId())).body(savedMove);
	    }
	     
}
