package com.christian.pray.services.impl;

import com.christian.pray.DTO.request.CellRequestDTO;
import com.christian.pray.DTO.response.CellResponseDTO;
import com.christian.pray.model.Cell;
import com.christian.pray.model.Church;
import com.christian.pray.repositories.CellRepository;
import com.christian.pray.services.CellService;
import com.christian.pray.services.ChurchService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CellServiceImpl implements CellService {

    private final CellRepository cellRepository;
    private final ChurchService churchService;
    private final ModelMapper modelMapper;

    public CellServiceImpl(CellRepository cellRepository, ChurchService churchService, ModelMapper modelMapper) {
        this.cellRepository = cellRepository;
        this.churchService = churchService;
        this.modelMapper = modelMapper;
    }


    @Override
    public Optional<Cell> getCellById(long idCell) {
        return Optional.ofNullable(cellRepository.findById(idCell))
                .orElseThrow(() -> new IllegalArgumentException("Celula não encontrada com o ID: " + idCell));
    }

    @Override
    public CellResponseDTO insertCell(CellRequestDTO cellDTO, long churchId) {
        Church church = churchService.getChurchById(churchId).get();
        Cell cell = modelMapper.map(cellDTO, Cell.class);
        cell.setChurch(church);
        cellRepository.save(cell);
        return modelMapper.map(cell, CellResponseDTO.class);
    }
}
