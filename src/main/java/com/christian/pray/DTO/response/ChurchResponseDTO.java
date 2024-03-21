package com.christian.pray.DTO.response;

import com.christian.pray.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChurchResponseDTO {

    private long id;
    private String name;

    private List<MemberResponseDTO> members;
}
