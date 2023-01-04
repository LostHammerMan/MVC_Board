package com.example.demo.config.auth;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessingUrl("/login)"
// login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어 있는 loadUserByName 함수가 실행
//
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    // 시큐리티 session(내부 Authentication(내부 UserDetails))
    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        UserVO userEntity = userDao.findByUserId(user_id);
        if (userEntity != null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
