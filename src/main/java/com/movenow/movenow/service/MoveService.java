package com.movenow.movenow.service;

import com.movenow.movenow.application.MoveUtils;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveDTO;
import com.movenow.movenow.domain.move.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

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
}
