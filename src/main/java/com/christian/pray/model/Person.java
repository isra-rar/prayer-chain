package com.christian.pray.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String cellphone;
    private LocalDate birthday;
    private boolean isMember;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<Pray> prays = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    private Cell cell;

    @JsonIgnore
    @ManyToOne
    private Church church;

}
