package com.ll.memberService.domain.member.eventListener;


import com.ll.memberService.domain.member.service.MemberService;
import com.ll.memberService.global.kafka.MemberProfileResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemberEventListener {

  private final MemberService memberService;

  @KafkaListener(
      topics = "signup",
      groupId = "member",
      containerFactory = "kafkaListenerContainerFactory"
  )public void consumeSingup(MemberProfileResponse response) {
    log.debug("Received member profile: {}", response);
    memberService.join(response);
  }
}
