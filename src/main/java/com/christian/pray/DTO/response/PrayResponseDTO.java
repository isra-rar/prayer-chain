package com.christian.pray.DTO.response;

import com.christian.pray.model.enums.PrayType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrayResponseDTO {

    private long id;
    private String targetPray;
    private String description;
    private PrayType prayType;
    private SimplePersonResponseDTO person;
}
