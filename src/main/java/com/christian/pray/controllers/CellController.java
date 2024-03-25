package com.christian.pray.controllers;

import com.christian.pray.DTO.response.CellResponseDTO;
import com.christian.pray.DTO.request.CellRequest;
import com.christian.pray.DTO.response.SimpleChurchResponseDTO;
import com.christian.pray.model.Cell;
import com.christian.pray.services.CellService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/cell")
@RequiredArgsConstructor
public class CellController {

    private final CellService cellService;

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Cell>> getChurch(@PathVariable long id) {
        return ResponseEntity.ok(cellService.getCellById(id));
    }

    @PostMapping("/church/{churchId}")
    public ResponseEntity<CellResponseDTO> insertCell(@RequestBody CellRequest cellRequest, @PathVariable long churchId) {
        CellResponseDTO cell = cellService.insertCell(cellRequest, churchId);
        return ResponseEntity
                .created(URI.create("/church/" + churchId + "/cell/" + cell.getId()))
                .body(cell);
    }


}
