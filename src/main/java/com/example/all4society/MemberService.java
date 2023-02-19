package com.example.all4society;

import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final EntityManager em;
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	@Transactional
	public Member 회원정보수정(String id, Member member){
		Member memberEntity = memberRepository.findById(id).orElseThrow();

		String rawPassword = member.getMemberPw();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);

		memberEntity.setMemberPw(encPassword);
		memberEntity.setMemberPhone(member.getMemberPhone());
		memberEntity.setMemberBirth(member.getMemberBirth());
		memberEntity.setMemberIntro(member.getMemberIntro());

		return memberEntity;
	}

	@Transactional(readOnly = true)
	public List<MemberDto> 아이디찾기(String member_phone) {// 전화번호로 아이디 찾기
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT memberId From member WHERE member_phone = '?'");

		Query query = em.createNativeQuery(sb.toString())
				.setParameter(1, member_phone);
		// qlrm 라이브러리 필요(Maven)
		JpaResultMapper result = new JpaResultMapper();
		List<MemberDto> memberDtos = result.list(query, MemberDto.class);

		return memberDtos;
	}

	// 비밀번호 찾기 위한 본인 인증
	@Transactional(readOnly = true)
	public MemberDto 비밀번호찾기(String member_id, String member_answer) {
		MemberDto memberDto = new MemberDto();

		Member memberEntity = memberRepository.findById(member_id).orElseThrow();
		if(memberEntity.getMemberAnswer().equals(member_answer)) { // 질문이 일치하는지 확인
			return memberDto;
		} else {
			return null;
		}


	}
	public Member 비밀번호변경(String id, Member member) {

		Member memberEntity = memberRepository.findById(id).orElseThrow();
		String rawPassword = member.getMemberPw();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		memberEntity.setMemberPw(encPassword);

		return memberEntity;
	}


}
