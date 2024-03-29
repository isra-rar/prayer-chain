package com.christian.pray.model;

import com.christian.pray.model.enums.PrayType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pray {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String targetPray;
    private String description;

    @Enumerated(EnumType.STRING)
    private PrayType prayType;

    @ManyToOne
    private Person person;

    @JsonIgnore
    @ManyToOne
    private Church church;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

}
