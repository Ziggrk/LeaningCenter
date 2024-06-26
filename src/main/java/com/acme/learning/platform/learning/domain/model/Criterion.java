package com.acme.learning.platform.learning.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.acme.learning.platform.shared.domain.model.AuditModel;
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

public class Criterion extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    //Relationships
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="skill_id", nullable = false)
    @JsonIgnore
    private Skill skill;
}
