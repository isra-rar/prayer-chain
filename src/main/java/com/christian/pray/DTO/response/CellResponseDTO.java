package com.christian.pray.DTO.response;

import com.christian.pray.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CellResponseDTO {

    private long id;
    private String name;
    private String leaderName;
    private long churchId;
    private List<User> members;
}
