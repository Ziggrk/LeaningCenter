package com.acme.leaningcenter.platform.learning.domain.model;
import com.acme.leaningcenter.platform.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank // Se diferencia del NotEmpty en la prohibicion de espacios en blanco.
    @Size(max=60)
    @Column(unique = true)
    private  String name;


    private int age;

    @Size(max = 240)
    private String address;
}
