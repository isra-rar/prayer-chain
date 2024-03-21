package com.christian.pray.controllers;

import com.christian.pray.DTO.request.CellRequestDTO;
import com.christian.pray.DTO.request.PrayRequestDTO;
import com.christian.pray.DTO.response.CellResponseDTO;
import com.christian.pray.DTO.response.PrayResponseDTO;
import com.christian.pray.DTO.response.SimpleChurchDTO;
import com.christian.pray.DTO.response.SimplePrayDTO;
import com.christian.pray.model.Pray;
import com.christian.pray.services.PrayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/pray")
@RequiredArgsConstructor
public class PrayController {

    private final PrayService prayService;

    @PostMapping("/member/{memberId}")
    public ResponseEntity<PrayResponseDTO> insertChurch(@RequestBody PrayRequestDTO prayRequestDTO, @PathVariable long memberId) {
        PrayResponseDTO pray = prayService.insertPray(prayRequestDTO, memberId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pray.getId()).toUri();
        return ResponseEntity.created(uri).body(pray);
    }

    @GetMapping("/member/{memberId}")
    private ResponseEntity<List<SimplePrayDTO>> getAllPraysMember(@PathVariable long memberId) {
        return ResponseEntity.ok(prayService.getAllPrayByIdMember(memberId));
    }

}
