package com.christian.pray.controllers;

import com.christian.pray.DTO.response.SimpleChurchResponseDTO;
import com.christian.pray.model.Church;
import com.christian.pray.services.ChurchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/church")
@RequiredArgsConstructor
public class ChurchController {

    private final ChurchService churchService;

    @GetMapping
    private ResponseEntity<List<SimpleChurchResponseDTO>> getAllChurch() {
        return ResponseEntity.ok(churchService.getAllChurchs());
    }

    @GetMapping("/{id}")
    private ResponseEntity<SimpleChurchResponseDTO> getChurch(@PathVariable long id) {
        return ResponseEntity.ok(churchService.getSimpleChurch(id));
    }

    @PostMapping
    public ResponseEntity<Church> insertChurch(@RequestBody Church  church) {
        Church newChurch = churchService.insertChurch(church);
        return ResponseEntity
                .created(URI.create("/" + newChurch.getId()))
                .body(newChurch);
    }


}
