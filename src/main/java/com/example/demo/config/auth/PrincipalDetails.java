package com.example.demo.config.auth;

// 시큐리티가 /login 낚아채서 로그인 진행
// 로그인 진행이 완료되면 시큐리티 session을 만들어줌(Security ContextHolder에 session 값 저장)
// 시큐리티 세션에 들어갈 수 있는 오브젝트 : Authentication 타입 객체
// Authentication 안에 User 정보가 있어야 됨.
// User오브젝트 타입 => UserDetails 타입 객체
// Security Session => Authentication => UserDetails(PrincipalDetails)

import com.example.demo.domain.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private UserVO user; // 콤포지션(구성)

    public PrincipalDetails(UserVO user) {
        this.user = user;
    }

    // 해당 User의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getUser_Role();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getUser_pw();
    }

    @Override
    public String getUsername() {
        return user.getUser_id();
    }

    // 계정이 만료되었는지 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있는지 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정의 기간이 지났는지 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화 되어 있는지 여부
    @Override
    public boolean isEnabled() {

        // 사이트에서 1년 동안 회원이 로그인을 안하면 휴먼계정으로 전환하기로 함
        // (현재시간 - 로그인 시간) => 1년을 초과할시 return false;

        return true;
    }
}
