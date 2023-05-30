package com.acme.learning.platform.learning.domain.persistence;

import com.acme.learning.platform.learning.domain.model.Criterion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CriterionRepository extends JpaRepository<Criterion, Long> {
    List<Criterion> findBySkillId(Long skillId);
    Page<Criterion> findBySkillId(Long id, Pageable pageable);

    Optional<Criterion> findByIdAndSkillId(Long id, Long skillId); //Optional permite entregar un nulo si no se encuentra uno que cumpla con los parametros dados
    Optional<Criterion> findVyNameAndSkillId(String name, Long skillId);
}
