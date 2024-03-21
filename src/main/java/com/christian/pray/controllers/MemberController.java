package com.christian.pray.controllers;

import com.christian.pray.DTO.request.MemberRequestDTO;
import com.christian.pray.DTO.response.MemberResponseDTO;
import com.christian.pray.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDTO> insertMember(@RequestBody MemberRequestDTO member) {
        MemberResponseDTO newMember = memberService.insertMember(member);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newMember.getId()).toUri();
        return ResponseEntity.created(uri).body(newMember);
    }

    @PatchMapping("/{memberId}/church/{churchId}")
    public ResponseEntity<Void> associatedChurch(@PathVariable Long memberId, @PathVariable Long churchId) {
        memberService.associatedMemberOfChurch(memberId, churchId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{memberId}/cell/{cellId}")
    public ResponseEntity<Void> associatedMember(@PathVariable Long memberId, @PathVariable Long cellId) {
        memberService.associatedMemberOfCell(memberId, cellId);
        return ResponseEntity.noContent().build();
    }

}
