package com.movenow.movenow.application;

import com.movenow.movenow.domain.Media;
import com.movenow.movenow.domain.MediaRepository;
import com.movenow.movenow.domain.UserRepository;
import com.movenow.movenow.domain.category.CategoryService;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveDTO;
import com.movenow.movenow.domain.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveUtils
{
    @Autowired
    CategoryService categoryService;

    @Autowired
    SkillService skillService;

    @Autowired
    MediaRepository mediaRepository;
    
    @Autowired
    UserRepository userRepository;

    public MoveDTO toDTO(Move move) {
        var moveDTO =  new MoveDTO(move);
        var category = categoryService.getCategory(move.getCategoryId());
        var skill = skillService.getSkill(move.getSkillId());
        
        //Big NoNo! (Use JPA)
        if(move.getCreatorId() != null) {
        	var user = userRepository.findById(move.getCreatorId());
        	moveDTO.setCreator(user.get());
        }

        
        if(category != null) {
          	moveDTO.setCategoryName(category.getName());
        }
        
        if(skill != null) {
            moveDTO.setSkillName(skill.getName());
        }

        if(move.getMediaId() != null)
        {
            Media media = mediaRepository.findById(move.getMediaId()).get();
            moveDTO.setPictureUrl(media.getPictureUrl());
            moveDTO.setVideoUrl(media.getVideoUrl());
        }

        return moveDTO;
    }
}
