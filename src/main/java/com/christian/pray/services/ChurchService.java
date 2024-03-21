package com.christian.pray.services;


import com.christian.pray.DTO.response.ChurchResponseDTO;
import com.christian.pray.DTO.response.SimpleChurchDTO;
import com.christian.pray.model.Church;

import java.util.List;
import java.util.Optional;

public interface ChurchService {

    Optional<Church> getChurchById(long churchId);
    SimpleChurchDTO getSimpleChurch(long churchId);

    List<SimpleChurchDTO> getAllChurchs();

    Church insertChurch(Church church);

}
