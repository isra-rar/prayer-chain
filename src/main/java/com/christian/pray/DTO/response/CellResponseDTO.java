package com.christian.pray.DTO.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CellResponseDTO {

    private long id;
    private String name;
    private List<PersonResponseDTO> persons;
}