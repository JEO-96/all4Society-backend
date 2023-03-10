package com.example.all4society.mypage.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.all4society.Member;
import com.example.all4society.MemberRepository;
import com.example.all4society.member.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MyPageService {
	
	private final MemberRepository memberRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//임시 세션값임
	@Transactional
	public String infoModify(MemberDto memberDto, String userId){
		Member memberEntity = memberRepository.findById(userId).orElseThrow();

		String rawPassword = memberDto.getMemberPw();
		memberEntity.updateMember(memberDto, rawPassword);

		return memberEntity.getMemberId();
	}
	
}
