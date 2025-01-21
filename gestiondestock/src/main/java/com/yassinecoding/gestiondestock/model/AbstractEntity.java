package com.yassinecoding.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    private Integer id;

    @Column(name = "creationDate", nullable = false)
    @CreatedDate
    @JsonIgnore
    private Instant creationDate;

    @Column(name = "lastModifiedDate")
    @LastModifiedDate
    @JsonIgnore
    private Instant lastModifiedDate;


}
