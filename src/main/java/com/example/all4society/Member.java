package com.example.all4society;

import javax.persistence.*;

import com.example.all4society.dto.member.MemberDto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@Column(name="member_id", nullable = false, unique = true)
	private String memberId;
	
	@Column(name="member_pw")
	private String memberPw;
	
	@Column(name="member_phone")
	private String memberPhone;
	
	@Column(name="member_birth")
	private String memberBirth;
	
	@Column(name="member_intro")
	private String memberIntro;

	@Column(name = "member_hint", nullable = false)
	private String memberHint;

	@Column(name = "member_answer", nullable = false)
	private String memberAnswer;

	private String role;	// USER, ADMIN

	public static Member createMember(MemberDto memberDto) {

		Member member = new Member();
		member.setMemberId(memberDto.getMemberId());
		member.setMemberPw(memberDto.getMemberPw());
		member.setMemberPhone(memberDto.getMemberPhone());
		member.setMemberBirth(memberDto.getMemberBirth());
		member.setMemberIntro(memberDto.getMemberIntro());
		return member;
	}
}
