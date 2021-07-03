package com.movenow.movenow.application;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.movenow.movenow.domain.User;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movenow.movenow.domain.Move;
import com.movenow.movenow.domain.MoveRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/api/moves")
public class MoveController {	
	
	   private final MoveRepository moveRepository;

	   public MoveController(MoveRepository moveRepository) {
	       this.moveRepository = moveRepository;
	   }
	    
	    @GetMapping
	    CollectionModel<EntityModel<Move>> getMoves() {

	    List<EntityModel<Move>> moves = moveRepository.findAll().stream()
	    		.map(move -> EntityModel.of(move, 
	    				linkTo(methodOn(MoveController.class).getMove(move.getId())).withSelfRel(),
	              		linkTo(methodOn(MoveController.class).getMoves()).withRel("moves")))
	    		.collect(Collectors.toList());

	    	return CollectionModel.of(moves, linkTo(methodOn(MoveController.class).getMoves()).withSelfRel());
	    }
	    
	    @GetMapping("/{id}")
		 EntityModel<Move> getMove(@PathVariable Long id) {

	    	Move move = moveRepository.findById(id).orElseThrow(RuntimeException::new);

		     return EntityModel.of(move,
		         linkTo(methodOn(MoveController.class).getMove(id)).withSelfRel(),
		         linkTo(methodOn(MoveController.class).getMoves()).withRel("moves"));
		   }

	

	    @PostMapping
	    public ResponseEntity createMove(@RequestBody Move move) throws URISyntaxException {
	    	var savedMove = moveRepository.save(move);
	        return ResponseEntity.created(new URI("/moves/" + savedMove.getId())).body(savedMove);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity updateMove(@PathVariable Long id, @RequestBody Move move) {
	        var currentMove = moveRepository.findById(id).orElseThrow(RuntimeException::new);
	        currentMove.setName(move.getName());
			currentMove.setDescription(move.getDescription());
			currentMove.setStartTime(move.getStartTime());
			currentMove.setEndTime(move.getEndTime());
			currentMove.setLatitude(move.getLatitude());
			currentMove.setLongitude(move.getLongitude());
	        currentMove = moveRepository.save(move);

	        return ResponseEntity.ok(currentMove);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity deleteMove(@PathVariable Long id) {
	    	moveRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }

		@PostMapping("/{id}/users")
		public ResponseEntity addUser(@PathVariable Long id, @RequestBody User user) throws URISyntaxException {
			var currentMove = moveRepository.findById(id).orElseThrow(RuntimeException::new);
			var currentMoveUsers = currentMove.getUsers();
			
			currentMoveUsers.add(user);			
			currentMove.setUsers(currentMoveUsers);
			moveRepository.save(currentMove);
			
			return ResponseEntity.created(new URI("/moves/" + currentMove.getId())).body(currentMove);
		}
}
