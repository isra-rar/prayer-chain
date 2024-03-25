package com.christian.pray.controllers;

import com.christian.pray.DTO.response.PersonResponseDTO;
import com.christian.pray.DTO.request.PersonRequest;
import com.christian.pray.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonResponseDTO> insertPerson(@RequestBody PersonRequest personRequest) {
        PersonResponseDTO person = personService.insertPerson(personRequest);
        return ResponseEntity
                .created(URI.create("/" + person.getId()))
                .body(person);
    }

    @PatchMapping("/{personId}/church/{churchId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associatePersonWithChurch(@PathVariable Long personId, @PathVariable Long churchId) {
        personService.associatedPersonOfChurch(personId, churchId);
    }

    @PatchMapping("/{personId}/cell/{cellId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associateMemberWithCell(@PathVariable Long personId, @PathVariable Long cellId) {
        personService.associatedPersonOfCell(personId, cellId);
    }

}
