package com.movenow.movenow.application;

import com.movenow.movenow.domain.Category;
import com.movenow.movenow.domain.Skill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private List<Skill> skills  = new ArrayList<>();

    @PostConstruct
    private void postConstruct() {
        skills.add(new Skill() {{
            setId(1L);
            setName("Anfänger");
        }});
        skills.add(new Skill() {{
            setId(2L);
            setName("Hobbysportler");
        }});
        skills.add(new Skill() {{
            setId(3L);
            setName("Profisportler");
        }});
    }

    @GetMapping
    public List<Skill> getSkills() {
        return skills;
    }

    @GetMapping("/{id}")
    public ResponseEntity getSkill(@PathVariable Long id) {
        for (Skill skill:
                skills) {
            if (skill.getId() == id) {
                return ResponseEntity.ok(skill);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
