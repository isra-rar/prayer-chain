package com.christian.pray.services;


import com.christian.pray.DTO.request.PrayRequestDTO;
import com.christian.pray.DTO.response.PrayResponseDTO;
import com.christian.pray.DTO.response.SimplePrayDTO;

import java.util.List;

public interface PrayService {

    PrayResponseDTO insertPray(PrayRequestDTO prayRequestDTO, long memberId);

    List<SimplePrayDTO> getAllPrayByIdMember(long memberId);


}
