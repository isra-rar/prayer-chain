package com.christian.pray.services;


import com.christian.pray.DTO.response.PrayResponseDTO;
import com.christian.pray.DTO.response.SimplePrayResponseDTO;
import com.christian.pray.DTO.request.PrayRequest;

import java.util.List;

public interface PrayService {

    SimplePrayResponseDTO getPrayById(long prayId);

    PrayResponseDTO insertPray(PrayRequest prayRequest, long personId);

    List<SimplePrayResponseDTO> getAllPrayByIdPerson(long personId);


}
