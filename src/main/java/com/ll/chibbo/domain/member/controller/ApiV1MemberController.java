package com.ll.chibbo.domain.member.controller;

import com.ll.chibbo.domain.member.dto.MemberResponse;
import com.ll.chibbo.domain.member.entity.Member;
import com.ll.chibbo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class ApiV1MemberController {

  private final MemberService memberService;

  @GetMapping("/me")
  public ResponseEntity<MemberResponse> me(@RequestHeader("X-Username") String username) {
    // API Gateway에서 전달한 사용자 정보 사용
    Member member = this.memberService.getMember(username);
    return ResponseEntity.ok(MemberResponse.of(member));
  }

  @GetMapping("/{username}")
  public MemberResponse getMember(@PathVariable String username) {
    Member member = this.memberService.getMember(username);
    return MemberResponse.of(member);
  }
}
