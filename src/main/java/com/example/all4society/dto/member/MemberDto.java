package com.example.all4society.dto.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class MemberDto {

	private String memberId;
	
	private String memberPw;
	private String memberName;
	private String memberDepartment;
	private String memberRank;
	private String memberPhone;
	
	private String memberBirth;
	
	private String memberIntro;
	private String memberHint;
	private String memberAnswer;

}
