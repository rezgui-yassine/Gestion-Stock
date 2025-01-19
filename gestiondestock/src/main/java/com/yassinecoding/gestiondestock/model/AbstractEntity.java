package com.yassinecoding.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


@Data
@MappedSuperclass
// @EntityListeners: pour activer l'audition des entités (pour les dates de création et de modification)
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    private Integer id;
    // @JsonIgnore: pour ne pas afficher cette propriété dans le JSON
    @Column(name = "creationDate", nullable = false)
    @CreatedDate
    @JsonIgnore
    private Instant creationDate;
    // @JsonIgnore: pour ne pas afficher cette propriété dans le JSON
    @Column(name = "lastModifiedDate" )
    @LastModifiedDate
    @JsonIgnore
    private Instant lastModifiedDate;
}
