package com.ll.chibbo.domain.member.entity;


import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = PROTECTED) // 기본 생성자 생성, protected 접근 제어
@AllArgsConstructor(access = PROTECTED) // 모든 필드 값을 파라미터로 받는 생성자 생성
@Getter // 모든 필드의 getter 메서드 생성
@Setter
@SuperBuilder // 상속된 클래스에서 빌더 패턴 사용 가능
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 기능 사용
@ToString // toString 메서드 자동 생성
@EqualsAndHashCode // equals와 hashCode 메서드 자동 생성
@Entity
public class Member {

  @Id
  private Long id;

  @Column(unique = true)
  private String username;

  @Column
  private String email;

  @Column
  private String nickname;

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;
}
