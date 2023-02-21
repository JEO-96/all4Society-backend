package com.example.all4society.mypage.service;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.all4society.Member;
import com.example.all4society.MemberRepository;
import com.example.all4society.dto.member.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MyPageService {
	
	private final MemberRepository memberRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//임시 세션값임
	@Transactional
	public String infoModify(MemberDto memberDto){
		Member memberEntity = memberRepository.findById(memberDto.getMemberId()).orElseThrow();

		String rawPassword = memberDto.getMemberPw();
		memberEntity.updateMember(memberDto, rawPassword);

		return memberEntity.getMemberId();
	}
	
}
