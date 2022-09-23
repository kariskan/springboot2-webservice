package com.kariskan.practice.webservice.domain.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    //email을 통해 이미 생성된 사용자인지 확인하기 위함
    Optional<Users> findByEmail(String email);
}
