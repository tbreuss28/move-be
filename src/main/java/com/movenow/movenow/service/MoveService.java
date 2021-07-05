package com.movenow.movenow.service;

import com.movenow.movenow.application.MoveUtils;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveDTO;
import com.movenow.movenow.domain.move.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoveService
{
    @Autowired
    private LocationService locationService;

    @Autowired
    private MoveRepository moveRepository;

    @Autowired
    private MoveUtils moveUtils;

    public ArrayList<MoveDTO> GetMovesOnLocation(Double latitude, Double longitude, Long radius)
    {
        var movesInDistance = new ArrayList<MoveDTO>();

        for (var move : moveRepository.findAll()) {
            var distanceFromPosition = locationService.CalculateDistance(latitude, longitude, move.getLatitude(), move.getLongitude());

            if (distanceFromPosition < radius) {
                MoveDTO moveDTO = moveUtils.toDTO(move);

                moveDTO.setDistanceFromUser(distanceFromPosition);

                movesInDistance.add(moveDTO);
            }
        }

        return movesInDistance;
    }

    public ArrayList<MoveDTO> ConvertListToMoveDTOs(List<Move> moves)
    {
        var moveDTOs = new ArrayList<MoveDTO>();

        for (Move move : moves) {
            moveDTOs.add(moveUtils.toDTO(move));
        }

        return moveDTOs;
    }
    
    public MoveDTO ConvertToMoveDTO(Move move){
        return moveUtils.toDTO(move);
    }
}
