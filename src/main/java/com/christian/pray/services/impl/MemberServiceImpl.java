package com.christian.pray.services.impl;

import com.christian.pray.DTO.request.MemberRequestDTO;
import com.christian.pray.DTO.response.MemberResponseDTO;
import com.christian.pray.model.Cell;
import com.christian.pray.model.Church;
import com.christian.pray.model.User;
import com.christian.pray.repositories.ChurchRepository;
import com.christian.pray.repositories.UserRepository;
import com.christian.pray.services.CellService;
import com.christian.pray.services.ChurchService;
import com.christian.pray.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final UserRepository memberRepository;
    private final CellService cellService;
    private final ChurchService churchService;
    private final ModelMapper modelMapper;

    public MemberServiceImpl(UserRepository userRepository, CellService cellService, ChurchService churchService, ModelMapper modelMapper) {
        this.memberRepository = userRepository;
        this.cellService = cellService;
        this.churchService = churchService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<User> getMemberById(long memberId) {
        return Optional.ofNullable(memberRepository.findById(memberId))
                .orElseThrow(() -> new IllegalArgumentException("User não encontrado com o ID: " + memberId));
    }

    @Override
    public MemberResponseDTO insertMember(MemberRequestDTO memberDTO) {
        User member = modelMapper.map(memberDTO, User.class);
        memberRepository.save(member);
        return modelMapper.map(member, MemberResponseDTO.class);
    }

    @Override
    public void associatedMemberOfChurch(Long memberId, Long churchId) {
        User member = getMemberById(memberId).get();
        Church church = churchService.getChurchById(churchId).get();
        member.setChurch(church);

        memberRepository.save(member);
    }

    @Override
    public void associatedMemberOfCell(Long memberId, Long cellId) {
        Cell cell = cellService.getCellById(cellId).get();
        User member = getMemberById(memberId).get();

        member.setCell(cell);
        memberRepository.save(member);
    }

}
