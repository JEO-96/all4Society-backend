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

	@Column(name = "member_name")	// 성명
	private String memberName;

	@Column(name = "member_department")	// 부서
	private String memberDepartment;

	@Column(name = "member_rank")	// 	직급
	private String memberRank;

	@Column(name="member_phone")
	private String memberPhone;
	
	@Column(name="member_birth")
	private String memberBirth;
	
	@Column(name="member_intro")
	private String memberIntro;

	@Column(name = "member_hint")
	private String memberHint;

	@Column(name = "member_answer")
	private String memberAnswer;

	private String role;	// USER, ADMIN

	public static Member createMember(MemberDto memberDto) {

		Member member = new Member();
		member.setMemberId(memberDto.getMemberId());
		member.setMemberPw(memberDto.getMemberPw());
		member.setMemberPhone(memberDto.getMemberPhone());
		member.setMemberBirth(memberDto.getMemberBirth());
		member.setMemberIntro(memberDto.getMemberIntro());
		member.setMemberHint(memberDto.getMemberHint());
		member.setMemberAnswer(memberDto.getMemberAnswer());
		member.setMemberDepartment(memberDto.getMemberDepartment());
		member.setMemberName(memberDto.getMemberName());
		member.setMemberRank(memberDto.getMemberRank());
		member.setRole("ROLE_USER");
		return member;
	}
	
	public void updateMember(MemberDto memberDto, String pw) {
	      this.memberPw = pw;
	      this.memberPhone = memberDto.getMemberPhone();
	      this.memberBirth = memberDto.getMemberBirth();
	      this.memberHint = memberDto.getMemberHint();
	      this.memberAnswer = memberDto.getMemberAnswer();
	      this.memberIntro = memberDto.getMemberIntro();
	   }
}
