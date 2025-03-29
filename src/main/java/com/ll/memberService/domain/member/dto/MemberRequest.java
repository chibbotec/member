package com.ll.memberService.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRequest {
  @NotBlank
  private String username;

  @NotBlank
  private String password;
}
