package com.acme.learning.platform.learning.domain.service;

import com.acme.learning.platform.learning.domain.model.Skill;
import com.acme.learning.platform.learning.domain.model.Student;
import com.acme.learning.platform.learning.domain.persistence.SkillRepository;
import com.acme.learning.platform.shared.exception.ResourceNotFoundException;
import com.acme.learning.platform.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hibernate.usertype.DynamicParameterizedType.ENTITY;

@Service
public class SkillServiceImpl implements SkillService {

    private static final String Entity = "Skill";
    private final SkillRepository skillRepository;
    private final Validator validator;

    public SkillServiceImpl(SkillRepository skillRepository, Validator validator) {
        this.skillRepository = skillRepository;
        this.validator = validator;
    }

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    @Override
    public Page<Skill> getAll(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public Skill getById(Long skillId) {
        return skillRepository.findById(skillId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, skillId));
    }

    @Override
    public Skill create(Skill skill) {
        Set<ConstraintViolation<Skill>> violations = validator.validate(skill);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(skillRepository.findByName(skill.getName()).isPresent())
            throw new ResourceValidationException(ENTITY, "An skill with the same name already exists.");
        return skillRepository.save(skill);

    }

    @Override
    public Skill update(Long id, Skill skill) {
        Set<ConstraintViolation<Skill>> violations = validator.validate(skill);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        //Name uniqueness validation
        Optional<Skill> skillWithName = skillRepository.findByName(skill.getName());

        if(skillWithName.isPresent() && !skillWithName.get().getId().equals(id)) // Se verifica si ese skill nombre existe, si existe pero NO es del que estas editando
            throw new ResourceValidationException(ENTITY, "An student with the same name already exists.");

        //Perform creation operation
        return skillRepository.findById(id).map(existingSkill ->
                        skillRepository.save(
                                existingSkill.withName(skill.getName())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ResponseEntity<?> delete(Long skillId) {
        return skillRepository.findById(skillId).map(skill -> {
            skillRepository.delete(skill);
            return ResponseEntity.ok().build();
        })
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, skillId));
    }

    @Override
    public Skill addCriterionToSkill(Long skillId, String criterionName) {
        return skillRepository.findById(skillId).map(skill->{
            return skillRepository.save(skill.addCriterion(criterionName));
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, skillId));
    }
}
