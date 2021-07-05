package com.movenow.movenow.application;

import com.movenow.movenow.domain.*;
import com.movenow.movenow.domain.category.CategoryService;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveDTO;
import com.movenow.movenow.domain.move.MoveRepository;
import com.movenow.movenow.domain.skill.SkillService;
import com.movenow.movenow.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/moves")
public class MoveController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	MoveRepository moveRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MoveUsersRepository moveUsersRepository;

	@Autowired
	MediaRepository mediaRepository;

	@Autowired
	MoveService moveService;

	@GetMapping
	List<MoveDTO> getMoves() {		
		List<Move> moves = moveRepository.findAll();
		List<MoveDTO> moveDTOs = moveService.ConvertListToMoveDTOs(moves);
		
		return moveDTOs;
	}

	@GetMapping("/{id}")
	 MoveDTO getMove(@PathVariable Long id) {
		Move move = moveRepository.findById(id).orElseThrow(RuntimeException::new);
		return moveService.ConvertToMoveDTO(move);
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
		currentMove.setMediaId(move.getMediaId());
		currentMove = moveRepository.save(move);

		return ResponseEntity.ok(currentMove);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteMove(@PathVariable Long id) {
		moveRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{moveId}/moveUsers")
	public List<MoveUser> moveUsers(@PathVariable Long moveId) throws URISyntaxException {
		var moveUsers = moveUsersRepository.findByMoveId(moveId);
		for (MoveUser moveUser : moveUsers) {
			Optional<User> user = userRepository.findById(moveUser.getUserId());
			moveUser.setUser( user.get());
		}
		return moveUsers;
	}

	@GetMapping("/movesOnDistanceToPoint")
	public ArrayList<MoveDTO> getMovesOnDistanceToPoint(@RequestParam Double latitude,
			@RequestParam Double longitude,
			@RequestParam Long radius)
	{
		return moveService.GetMovesOnLocation(latitude, longitude, radius);
	}
}
