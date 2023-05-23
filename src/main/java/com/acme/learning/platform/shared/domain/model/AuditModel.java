package com.acme.learning.platform.shared.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updateAt"}, allowGetters = true)
public abstract  class AuditModel {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name="updated_at", nullable= false)
    @Temporal(TemporalType.TIMESTAMP)
     private Date updateAt;
}
