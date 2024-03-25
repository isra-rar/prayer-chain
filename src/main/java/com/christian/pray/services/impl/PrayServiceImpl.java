package com.christian.pray.services.impl;

import com.christian.pray.DTO.response.PrayResponseDTO;
import com.christian.pray.DTO.response.SimplePrayResponseDTO;
import com.christian.pray.DTO.request.PrayRequest;
import com.christian.pray.model.Person;
import com.christian.pray.model.Pray;
import com.christian.pray.repositories.PrayRepository;
import com.christian.pray.services.PersonService;
import com.christian.pray.services.PrayService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrayServiceImpl implements PrayService {

    private final ModelMapper modelMapper;
    private final PersonService personService;
    private final PrayRepository prayRepository;

    public PrayServiceImpl(ModelMapper modelMapper, PersonService personService, PrayRepository prayRepository) {
        this.modelMapper = modelMapper;
        this.personService = personService;
        this.prayRepository = prayRepository;
    }


    @Override
    public SimplePrayResponseDTO getPrayById(long prayId) {
        Optional<Pray> pray = Optional.ofNullable(prayRepository.findById(prayId))
                .orElseThrow(() -> new IllegalArgumentException("Oração não encontrado com o ID: " + prayId));
        return modelMapper.map(pray, SimplePrayResponseDTO.class);
    }

    @Override
    public PrayResponseDTO insertPray(PrayRequest prayRequest, long personId) {
        Person person = personService.getPersonById(personId).get();
        Pray pray = toEntity(prayRequest, person);
        prayRepository.save(pray);
        return toDto(pray);
    }

    @Override
    public List<SimplePrayResponseDTO> getAllPrayByIdPerson(long personId) {
        return prayRepository.getPraysByPersonId(personId).stream()
                .map(pray -> modelMapper.map(pray, SimplePrayResponseDTO.class)).collect(Collectors.toList());
    }

    private Pray toEntity(PrayRequest prayRequest, Person person) {
        Pray pray = modelMapper.map(prayRequest, Pray.class);
        pray.setPerson(person);
        pray.setChurch(person.getChurch());
        return pray;
    }

    private PrayResponseDTO toDto(Pray pray) {
        return modelMapper.map(pray, PrayResponseDTO.class);
    }

}
