package com.christian.pray.services.impl;

import com.christian.pray.DTO.request.PrayRequestDTO;
import com.christian.pray.DTO.response.PrayResponseDTO;
import com.christian.pray.DTO.response.SimplePrayDTO;
import com.christian.pray.model.Pray;
import com.christian.pray.model.User;
import com.christian.pray.repositories.PrayRepository;
import com.christian.pray.services.MemberService;
import com.christian.pray.services.PrayService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrayServiceImpl implements PrayService {

    private final ModelMapper modelMapper;
    private final MemberService memberService;
    private final PrayRepository prayRepository;

    public PrayServiceImpl(ModelMapper modelMapper, MemberService memberService, PrayRepository prayRepository) {
        this.modelMapper = modelMapper;
        this.memberService = memberService;
        this.prayRepository = prayRepository;
    }


    @Override
    public PrayResponseDTO insertPray(PrayRequestDTO prayRequestDTO, long memberId) {
        User member = memberService.getMemberById(memberId).get();
        Pray pray = modelMapper.map(prayRequestDTO, Pray.class);
        pray.setMember(member);
        pray.setChurch(member.getChurch());
        prayRepository.save(pray);
        return modelMapper.map(pray, PrayResponseDTO.class);
    }

    @Override
    public List<SimplePrayDTO> getAllPrayByIdMember(long memberId) {
        return prayRepository.getPraysByMemberId(memberId).stream()
                .map(pray -> modelMapper.map(pray, SimplePrayDTO.class)).collect(Collectors.toList());
    }
}
