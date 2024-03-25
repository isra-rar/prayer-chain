package com.christian.pray.services.impl;

import com.christian.pray.DTO.response.SimplePrayResponseDTO;
import com.christian.pray.model.Pray;
import com.christian.pray.model.Prayed;
import com.christian.pray.model.Person;
import com.christian.pray.repositories.PrayedRepository;
import com.christian.pray.services.PersonService;
import com.christian.pray.services.PrayService;
import com.christian.pray.services.PrayedService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PrayedServiceImpl implements PrayedService {

    private final PersonService personService;
    private final PrayService prayService;
    private final PrayedRepository prayedRepository;
    private final ModelMapper modelMapper;

    @Override
    public void associatedPrayOfPerson(Long personId, Long prayId) {
        try {
            Person person = personService.getPersonById(personId).get();
            SimplePrayResponseDTO pray = prayService.getPrayById(prayId);

            prayedRepository.save(Prayed.builder()
                    .person(person)
                    .pray(modelMapper.map(pray, Pray.class))
                    .createdAt(LocalDateTime.now())
                    .build());
        }
         catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Você já orou essa oração!");
         }

    }
}
