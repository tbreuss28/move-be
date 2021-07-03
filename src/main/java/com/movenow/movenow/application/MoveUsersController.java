package com.movenow.movenow.application;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
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
	    CollectionModel<EntityModel<MoveUser>> all() {
	   
	   		List<EntityModel<MoveUser>> moveUsers = moveUsersRepository.findAll()
	    		.stream()
	    		.map(moveUser -> EntityModel.of(moveUser, 
	    				linkTo(methodOn(MoveUsersController.class).one(moveUser.getId())).withSelfRel(),
	              		linkTo(methodOn(MoveUsersController.class).all()).withRel("moveUsers")))
	    		.collect(Collectors.toList());

	    	return CollectionModel.of(moveUsers, linkTo(methodOn(MoveController.class).getMoves()).withSelfRel());
		   
	    }
	       
	   @GetMapping("/{id}")
	   EntityModel<MoveUser> one(@PathVariable Long id) {
		   MoveUser moveUser = moveUsersRepository.findById(id).orElseThrow(RuntimeException::new);

		   return EntityModel.of(moveUser,
				   linkTo(methodOn(MoveUsersController.class).one(id)).withSelfRel(),
				   linkTo(methodOn(MoveUsersController.class).all()).withRel("moves"));
	   }
	   
	   @PostMapping
	    public ResponseEntity<MoveUser> create(@RequestBody MoveUser moveUser) throws URISyntaxException {   
		   var savedMove =  moveUsersRepository.save(moveUser);
	       return ResponseEntity.created(new URI("/moveUsers/" + savedMove.getId())).body(savedMove);
	    }
	     
}
