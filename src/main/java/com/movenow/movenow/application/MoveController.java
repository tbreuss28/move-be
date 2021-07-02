package com.movenow.movenow.application;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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


@RestController
@RequestMapping("/api/moves")
public class MoveController {
	
	
	   private final MoveRepository moveRepository;

	   public MoveController(MoveRepository moveRepository) {
	       this.moveRepository = moveRepository;
	   }

	    @GetMapping
	    public List<Move> getClients() {
	        return moveRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Move getClient(@PathVariable Long id) {
	        return moveRepository.findById(id).orElseThrow(RuntimeException::new);
	    }

	    @PostMapping
	    public ResponseEntity createClient(@RequestBody Move move) throws URISyntaxException {
	    	Move savedMove = moveRepository.save(move);
	        return ResponseEntity.created(new URI("/clients/" + savedMove.getId())).body(savedMove);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Move move) {
	        Move currentMove = moveRepository.findById(id).orElseThrow(RuntimeException::new);
	        currentMove.setName(move.getName());
	        currentMove = moveRepository.save(move);

	        return ResponseEntity.ok(currentMove);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity deleteClient(@PathVariable Long id) {
	    	moveRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }

}
