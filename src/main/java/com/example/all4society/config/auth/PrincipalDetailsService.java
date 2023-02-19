package com.example.all4society.config.auth;

import com.example.all4society.Member;
import com.example.all4society.MemberRepository;
import com.example.all4society.config.auth.PrincipalDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService{

    private final MemberRepository memberRepository;

    // 1.패스워드는 알아서 체킹하니까 신경쓸 필요 없다.
    // 2.리턴이 잘되면 자동으로 MemberDetails 타입을 세션으로 만든다.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member memberEntity = memberRepository.findByMemberId(username);
        log.info(username);

        if(memberEntity == null) {
            return null;
        } else {
            return new PrincipalDetails(memberEntity);
        }

    }

}
