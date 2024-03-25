package com.christian.pray.services;


import com.christian.pray.DTO.response.PersonResponseDTO;
import com.christian.pray.DTO.request.PersonRequest;
import com.christian.pray.model.Person;

import java.util.Optional;

public interface PersonService {

    Optional<Person> getPersonById(long personId);

    PersonResponseDTO insertPerson(PersonRequest personRecord);


    void associatedPersonOfChurch(Long personId, Long churchId);

    void associatedPersonOfCell(Long personId, Long cellId);

}
