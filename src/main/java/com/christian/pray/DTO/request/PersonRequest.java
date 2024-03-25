package com.christian.pray.DTO.request;

import java.time.LocalDate;

public record PersonRequest(String username, String password, String name, String email, String cellphone, LocalDate birthday, boolean isMember) { }
