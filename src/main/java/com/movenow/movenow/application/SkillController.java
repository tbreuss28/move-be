package com.movenow.movenow.application;

import com.movenow.movenow.domain.Skill;
import com.movenow.movenow.domain.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;





@RestController
@RequestMapping("/api/skills")
public class SkillController {
	
	@Autowired
	SkillService skillService;


 

    @GetMapping
    public List<Skill> getSkills() {
        return skillService.getSkills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable Long id) {
    	
    	try {
    		return ResponseEntity.ok(skillService.getSkill(id));
    	} catch(Exception e) {
            return ResponseEntity.notFound().build();
    	}        

    }
}
