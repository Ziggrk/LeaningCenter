package com.acme.leaningcenter.platform.learning.domain.model;

import com.acme.leaningcenter.platform.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@With // para constructores con un solo valor
@Entity // Significa que esta clase sera un entidad en mi base de datos
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "criteria") // se especifica el nombre para tener una convencion correcta

public class Criterion  extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relationships
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="skill_id", nullable = false)
    @JsonIgnore
    private Skill skill;
}
