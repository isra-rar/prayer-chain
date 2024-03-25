package com.christian.pray.services;


import com.christian.pray.DTO.response.SimpleChurchResponseDTO;
import com.christian.pray.model.Church;

import java.util.List;
import java.util.Optional;

public interface ChurchService {

    Optional<Church> getChurchById(long churchId);
    SimpleChurchResponseDTO getSimpleChurch(long churchId);

    List<SimpleChurchResponseDTO> getAllChurchs();

    Church insertChurch(Church church);

}
