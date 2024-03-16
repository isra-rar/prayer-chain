package com.christian.pray.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "church")
    private List<Cell> cells = new ArrayList<>();

    @OneToMany(mappedBy = "church")
    private List<User> members = new ArrayList<>();

    @OneToMany(mappedBy = "church")
    private List<Pray> prays = new ArrayList<>();
}
