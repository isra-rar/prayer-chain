package com.christian.pray.DTO.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberResponseDTO {

    private long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String cellphone;
    private LocalDate birthday;

}