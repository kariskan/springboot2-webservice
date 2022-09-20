package com.kariskan.practice.webservice.domain;

//JPA Auditing을 활용한 생성/수정 시간 자동화

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
/*
JPA Entity 클래스들이 이 클래스를 상속받을 경우,
필드들(createdDate, modifiedDate)도 자동으로 컬럼으로 인식함
 */
@EntityListeners(AuditingEntityListener.class)
/*
BaseTimeEntity 클래스에 Auditing 기능을 포함
 */
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
