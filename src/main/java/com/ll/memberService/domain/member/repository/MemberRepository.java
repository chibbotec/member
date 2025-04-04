package com.ll.memberService.domain.member.repository;

import com.ll.memberService.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findByUsername(String username);
  Member findByUsernameOrNickname(String username, String nickname);
}
