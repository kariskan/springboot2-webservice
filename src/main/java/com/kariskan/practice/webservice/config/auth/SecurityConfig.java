package com.kariskan.practice.webservice.config.auth;

import com.kariskan.practice.webservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    /**
     * csrf().disable().headers().frameOptions().disalbe() : h2-console 화면을 사용하기 위해 해당 옵션들을 disable
     * 한다. csrf란? https://velog.io/@woohobi/Spring-security-csrf%EB%9E%80
     * <p>
     * authorizeRequests: URL별 권한 관리를 설정하는 옵션의 시작점이다. antMatchers 옵션을 사용할 수 있음
     * <p>
     * antMatchers: 권한 관리 대상을 지정하는 옵션이고, URL, HTTP 메소드별로 관리가 가능하다. 첫 줄은 모두 허용(permitAll())이고,
     * api/v1/** 주소를 가진 URL은 USER 권한을 가진 사람만 허용
     * <p>
     * anyRequest.authenticated: 이외의 모든 요청은 인증된 사용자들에게만 허용하게 한다. 즉 로그인된 사용자
     * <p>
     * logout().logoutSuccessUrl("/"): 로그아웃 성공시 / 주소로 이동
     * <p>
     * oauth2Login: OAuth2 로그인 기능에 대한 여러 설정의 진입점
     * <p>
     * userInfoEndpoint: OAuth 2 로그인 성공 이후에 사용자 정보를 가져올 때의 설정들을 담당
     * <p>
     * userService: 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록 리소스 서버(구글, 네이버, 카카오)에서 사용자 정보를
     * 가져온 상태에서 추가로 진행하고자 하는 기능을 명시
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "profile")
                .permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        return http.build();
    }
}