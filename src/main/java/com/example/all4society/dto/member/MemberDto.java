package com.example.all4society.dto.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MemberDto {

	private String memberId;
	
	private String memberPw;
	
	private String memberPhone;
	
	private String memberBirth;
	
	private String memberIntro;

}