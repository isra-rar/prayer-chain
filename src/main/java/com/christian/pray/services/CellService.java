package com.christian.pray.services;


import com.christian.pray.DTO.response.CellResponseDTO;
import com.christian.pray.DTO.request.CellRequest;
import com.christian.pray.model.Cell;

import java.util.Optional;

public interface CellService {

    Optional<Cell> getCellById(long idCell);
    CellResponseDTO insertCell(CellRequest cellDTO, long churchId);


}
