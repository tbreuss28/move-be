package com.movenow.movenow.domain.skill;

import com.movenow.movenow.domain.Skill;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkillService {

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

    public List<Skill> getSkills() {
        return skills;
    }

    public Skill getSkill(Long id) {
        for (Skill skill:
                skills) {
            if (skill.getId() == id) {
            	return skill;
            }
        }
        throw new NullPointerException();
    }
}
