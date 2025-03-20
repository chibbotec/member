package com.ll.chibbo.domain.member.dto;

import com.ll.chibbo.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponse {
  private Long id;
  private String username;
  private String email;
  private String nickname;

  public MemberResponse(Member member) {
    this.id = member.getId();
    this.username = member.getUsername();
    this.email = member.getEmail();
    this.nickname = member.getNickname();

  }

  public static MemberResponse of(Member member) {
    return new MemberResponse(member);
  }
}
