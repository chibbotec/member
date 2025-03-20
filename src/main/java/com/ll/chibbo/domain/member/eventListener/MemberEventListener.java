package com.ll.chibbo.domain.member.eventListener;


import com.ll.chibbo.domain.member.service.MemberService;
import com.ll.chibbo.global.kafka.MemberProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberEventListener {

  private final MemberService memberService;

  @KafkaListener(
      topics = "signup",
      groupId = "member",
      containerFactory = "kafkaListenerContainerFactory"
  )public void consumeSingup(MemberProfileResponse response) {
    memberService.join(response);
  }
}
