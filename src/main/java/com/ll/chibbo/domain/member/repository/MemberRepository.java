package com.ll.chibbo.domain.member.repository;

import com.ll.chibbo.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findByUsername(String username);
}
