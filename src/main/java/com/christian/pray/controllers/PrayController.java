package com.christian.pray.controllers;

import com.christian.pray.DTO.response.PrayResponseDTO;
import com.christian.pray.DTO.response.SimplePrayResponseDTO;
import com.christian.pray.DTO.request.PrayRequest;
import com.christian.pray.services.PrayService;
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
@RequestMapping(value = "api/pray")
@RequiredArgsConstructor
public class PrayController {

    private final PrayService prayService;

    @PostMapping("/person/{personId}")
    public ResponseEntity<PrayResponseDTO> insertPray(@RequestBody PrayRequest prayRequest, @PathVariable long personId) {
        PrayResponseDTO pray = prayService.insertPray(prayRequest, personId);
        return ResponseEntity
                .created(URI.create("/person/" + personId + "/pray/" + pray.getId()))
                .body(pray);
    }

    @GetMapping("/person/{personId}")
    private ResponseEntity<List<SimplePrayResponseDTO>> getAllPraysPerson(@PathVariable long personId) {
        return ResponseEntity.ok(prayService.getAllPrayByIdPerson(personId));
    }

}
