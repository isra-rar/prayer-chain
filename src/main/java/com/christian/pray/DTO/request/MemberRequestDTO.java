package com.christian.pray.DTO.request;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberRequestDTO {

    private String username;
    private String password;
    private String name;
    private String email;
    private String cellphone;
    private LocalDate birthday;

}