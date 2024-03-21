package com.christian.pray.controllers;

import com.christian.pray.DTO.request.CellRequestDTO;
import com.christian.pray.DTO.response.CellResponseDTO;
import com.christian.pray.services.CellService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/cell")
@RequiredArgsConstructor
public class CellController {

    private final CellService cellService;

    @PostMapping("/church/{churchId}")
    public ResponseEntity<CellResponseDTO> insertChurch(@RequestBody CellRequestDTO cellRequestDTO, @PathVariable long churchId) {
        CellResponseDTO cell = cellService.insertCell(cellRequestDTO, churchId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cell.getId()).toUri();
        return ResponseEntity.created(uri).body(cell);
    }


}
