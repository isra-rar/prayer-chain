package com.christian.pray.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String cellphone;
    private LocalDate birthday;

    @OneToMany(mappedBy = "member")
    private List<Pray> prays = new ArrayList<>();

    @ManyToOne
    private Cell cell;

    @ManyToOne
    private Church church;

}
