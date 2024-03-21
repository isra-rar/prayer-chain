package com.christian.pray.DTO.response;

import com.christian.pray.model.enums.PrayType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrayResponseDTO {

    private long id;
    private String targetPray;
    private String description;

    @Enumerated(EnumType.STRING)
    private PrayType prayType;

    private SimpleMemberDTO member;

}
