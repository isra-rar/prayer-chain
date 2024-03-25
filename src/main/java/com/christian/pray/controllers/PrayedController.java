package com.christian.pray.controllers;

import com.christian.pray.services.PrayedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/prayed")
@RequiredArgsConstructor
public class PrayedController {

    private final PrayedService prayedService;

    @PostMapping("/pray/{prayId}/person/{personId}")
    public ResponseEntity<Void> associatedPrayofPerson(@PathVariable long prayId, @PathVariable long personId) {
        prayedService.associatedPrayOfPerson(personId, prayId);
         return ResponseEntity.noContent().build();
    }


}
