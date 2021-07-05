package com.movenow.movenow.application;

import com.movenow.movenow.domain.*;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveDTO;
import com.movenow.movenow.domain.move.MoveRepository;
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
public class MoveController
{

    @Autowired
    MoveUtils moveUtils;

    @Autowired
    MoveService moveService;

    private final MoveRepository moveRepository;
    private final UserRepository userRepository;
    private final MoveUsersRepository moveUsersRepository;
    private final MediaRepository mediaRepository;


    public MoveController(MoveRepository moveRepository,
            UserRepository userRepository,
            MoveUsersRepository moveUsersRepository,
            MediaRepository mediaRepository)
    {
        this.moveRepository = moveRepository;
        this.userRepository = userRepository;
        this.moveUsersRepository = moveUsersRepository;
        this.mediaRepository = mediaRepository;
    }

    @GetMapping
    List<MoveDTO> getMoves()
    {
        List<MoveDTO> moveDTOs = new ArrayList<>();
        List<Move> moves = moveRepository.findAll();
        for (Move move : moves) {
            moveDTOs.add(moveUtils.toDTO(move));
        }
        return moveDTOs;
    }

    @GetMapping("/{id}")
    MoveDTO getMove(@PathVariable Long id)
    {
        Move move = moveRepository.findById(id).orElseThrow(RuntimeException::new);
        return moveUtils.toDTO(move);
    }

    @PostMapping
    public ResponseEntity createMove(@RequestBody Move move) throws URISyntaxException
    {
        var savedMove = moveRepository.save(move);
        return ResponseEntity.created(new URI("/moves/" + savedMove.getId())).body(savedMove);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMove(@PathVariable Long id, @RequestBody Move move)
    {
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
    public ResponseEntity deleteMove(@PathVariable Long id)
    {
        moveRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{moveId}/moveUsers")
    public List<MoveUser> moveUsers(@PathVariable Long moveId)
	{
        var moveUsers = moveUsersRepository.findByMoveId(moveId);
        for (MoveUser moveUser : moveUsers) {
            Optional<User> user = userRepository.findById(moveUser.getUserId());
            moveUser.setUser(user.get());
        }
        return moveUsers;
    }

    @GetMapping("/api/movesOnDistanceToPoint")
    public ArrayList<MoveDTO> getMovesOnDistance(@RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Long radius)
	{
        return moveService.GetMovesOnLocation(latitude, longitude, radius);
    }

}
