package com.yassinecoding.gestiondestock.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

@Table(name = "vents")
public class Vents extends AbstractEntity {

    // FIXME: Add the missing fields
    private String code;
}
