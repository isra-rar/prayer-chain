package com.christian.pray.services.impl;

import com.christian.pray.DTO.response.PersonResponseDTO;
import com.christian.pray.DTO.request.PersonRequest;
import com.christian.pray.model.Cell;
import com.christian.pray.model.Church;
import com.christian.pray.model.Person;
import com.christian.pray.repositories.PersonRepository;
import com.christian.pray.services.CellService;
import com.christian.pray.services.ChurchService;
import com.christian.pray.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final CellService cellService;
    private final ChurchService churchService;
    private final ModelMapper modelMapper;

    public PersonServiceImpl(PersonRepository userRepository, CellService cellService, ChurchService churchService, ModelMapper modelMapper) {
        this.personRepository = userRepository;
        this.cellService = cellService;
        this.churchService = churchService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<Person> getPersonById(long personId) {
        return Optional.ofNullable(personRepository.findById(personId))
                .orElseThrow(() -> new IllegalArgumentException("User não encontrado com o ID: " + personId));
    }

    @Override
    public PersonResponseDTO insertPerson(PersonRequest personRecord) {
        Person person = modelMapper.map(personRecord, Person.class);
        personRepository.save(person);
        return modelMapper.map(person, PersonResponseDTO.class);
    }

    @Override
    public void associatedPersonOfChurch(Long personId, Long churchId) {
        Person person = getPersonById(personId).get();
        Church church = churchService.getChurchById(churchId).get();
        person.setChurch(church);

        personRepository.save(person);
    }

    @Override
    public void associatedPersonOfCell(Long personId, Long cellId) {
        Cell cell = cellService.getCellById(cellId).get();
        Person person = getPersonById(personId).get();

        person.setCell(cell);
        personRepository.save(person);
    }

}
