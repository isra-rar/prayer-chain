package com.christian.pray.DTO.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChurchResponseDTO {

    private long id;
    private String name;
    private String leaderName;
    private long churchId;
    private List<SimplePersonResponseDTO> members;
}
