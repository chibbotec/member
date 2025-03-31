package com.ll.memberService.domain.member.service;

import com.ll.memberService.domain.member.entity.Member;
import com.ll.memberService.domain.member.repository.MemberRepository;
import com.ll.memberService.global.kafka.MemberProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public Member join(MemberProfileResponse response) {
    Member member = Member.builder()
        .id(response.getId())
        .username(response.getUsername())
        .email(response.getEmail())
        .nickname(response.getNickname())
        .build();

    return memberRepository.save(member);
  }

  @Transactional(readOnly = true)
  public Member getMember(String username) {
    return memberRepository.findByUsername(username);
  }

  @Transactional(readOnly = true)
  public Member getMemberById(Long id) {
    return memberRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다: " + id));
  }

  public Member searchMember(String keyword) {
    return memberRepository.findByUsernameOrNickname(keyword,keyword);
  }
}