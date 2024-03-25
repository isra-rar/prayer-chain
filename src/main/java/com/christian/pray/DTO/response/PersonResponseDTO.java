package com.christian.pray.DTO.response;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponseDTO {

    private long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String cellphone;
    private LocalDate birthday;
    private boolean isMember;
}
