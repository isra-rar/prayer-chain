package com.christian.pray.services.impl;

import com.christian.pray.DTO.response.SimpleChurchResponseDTO;
import com.christian.pray.model.Church;
import com.christian.pray.repositories.ChurchRepository;
import com.christian.pray.services.ChurchService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChurchServiceImpl implements ChurchService {

    private final ChurchRepository churchRepository;
    private final ModelMapper modelMapper;

    public ChurchServiceImpl(ChurchRepository churchRepository, ModelMapper modelMapper) {
        this.churchRepository = churchRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SimpleChurchResponseDTO> getAllChurchs() {
        return churchRepository.findAll().stream()
                .map(church -> modelMapper.map(church, SimpleChurchResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<Church> getChurchById(long churchId) {
        return Optional.ofNullable(churchRepository.findById(churchId))
                .orElseThrow(() -> new IllegalArgumentException("Igreja não encontrado com o ID: " + churchId));
    }

    @Override
    public SimpleChurchResponseDTO getSimpleChurch(long churchId) {
        Church church = getChurchById(churchId).get();
        return modelMapper.map(church, SimpleChurchResponseDTO.class);

    }

    @Override
    public Church insertChurch(Church church) {
        return churchRepository.save(church);
    }

}
