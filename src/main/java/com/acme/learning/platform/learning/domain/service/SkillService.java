package com.acme.learning.platform.learning.domain.service;


import com.acme.learning.platform.learning.domain.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface SkillService {
    List<Skill> getAll();
    Page<Skill> getAll(Pageable pageable);

    Skill getById(Long skillId);
    Skill create(Skill skill);
    Skill update(Long id, Skill skill);
    ResponseEntity<?> delete(Long skillId); // este es un response porque al eliminar solo te devolvera si fue exitoso o no
    Skill addCriterionToSkill(Long skillId, String criterionName);
}
