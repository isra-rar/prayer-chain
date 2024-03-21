package com.christian.pray.services;


import com.christian.pray.DTO.request.MemberRequestDTO;
import com.christian.pray.DTO.response.MemberResponseDTO;
import com.christian.pray.model.User;

import java.util.Optional;

public interface MemberService {

    Optional<User> getMemberById(long memberId);

    MemberResponseDTO insertMember(MemberRequestDTO memberDTO);


    void associatedMemberOfChurch(Long memberId, Long churchId);

    void associatedMemberOfCell(Long memberId, Long cellId);

}
