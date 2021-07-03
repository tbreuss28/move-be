package com.movenow.movenow.application;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.movenow.movenow.domain.Category;
import com.movenow.movenow.domain.MoveUser;
import com.movenow.movenow.domain.MoveUsersRepository;
import com.movenow.movenow.domain.Skill;
import com.movenow.movenow.domain.User;
import com.movenow.movenow.domain.UserRepository;
import com.movenow.movenow.domain.category.CategoryService;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveDTO;
import com.movenow.movenow.domain.move.MoveRepository;
import com.movenow.movenow.domain.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/api/moves")
public class MoveController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SkillService skillService;
	
   private final MoveRepository moveRepository;
   private final UserRepository userRepository;
   private final MoveUsersRepository moveUsersRepository;



   public MoveController(MoveRepository moveRepository, UserRepository userRepository, MoveUsersRepository moveUsersRepository) {
	   this.moveRepository = moveRepository;
	   this.userRepository = userRepository;
	   this.moveUsersRepository = moveUsersRepository;
   }
	
	@GetMapping
	List<MoveDTO> getMoves() {
		List<MoveDTO> moveDTOs = new ArrayList<>();
		List<Move> moves = moveRepository.findAll();
		for (Move move : moves) {
			moveDTOs.add(toDTO(move));
		}
		return moveDTOs;
	}
	
	@GetMapping("/{id}")
	 MoveDTO getMove(@PathVariable Long id) {

		Move move = moveRepository.findById(id).orElseThrow(RuntimeException::new);
		return toDTO(move);
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

	@GetMapping("/{id}/users")
	public List<User> moveUsers(@PathVariable Long id) throws URISyntaxException {
		List<Long> userIds = new ArrayList<>();
		List<MoveUser> moveUsers = moveUsersRepository.findByMoveId(id);
		for (MoveUser moveUser : moveUsers) {
			var userId = moveUser.getUserId();
			userIds.add(moveUser.getUserId());
		}
   
	
		return userRepository.findByIdIn(userIds);
	}
	

	private MoveDTO toDTO(Move move) {
		var moveDTO =  new MoveDTO(move);
		
		if(move.getCategoryId() != null) {
			Category category = categoryService.getCategory(move.getCategoryId());
			moveDTO.setCategoryName(category.getName());
		}
		
		if(move.getSkillId() != null) {
			Skill skill = skillService.getSkill(move.getSkillId());
			moveDTO.setSkillName(skill.getName());		
		}
		
		return moveDTO;
	}
	    

}
