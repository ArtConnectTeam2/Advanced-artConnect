package com.multi.artConnect.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.multi.artConnect.member.MemberVO;

import lombok.Setter;

import com.multi.artConnect.mapper.MemberMapper;
import com.multi.artConnect.member.CustomUser;
import com.multi.artConnect.member.MemberDAO;
import com.multi.artConnect.member.MemberService;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

   
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.warn("로그인한 아이디 : " + userName);

        // userName은 userid를 의미합니다
        MemberVO vo = memberMapper.read(userName);

        log.warn("맴버 정보: " + vo);

        if (vo == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }

        return new CustomUser(vo);
    }
}
