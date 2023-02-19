package com.example.all4society.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.example.all4society.Member;
import com.example.all4society.dto.member.MemberDto;
import com.example.all4society.MemberRepository;
import com.example.all4society.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/member")
@RequiredArgsConstructor
public class MemberController {

	final private static Logger LOG = Logger.getGlobal();
	public static final String SECURED_TEXT = "Hello from the secured resource!";
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberService memberService;

	@GetMapping(value="/idcheck.json")
	public Map<String, Object> idCheckGET(@RequestParam(name="id") String id) {
		System.out.println(id);
		Map<String, Object> map = new HashMap<>();
		try {
			boolean ret = memberRepository.existsByMemberId(id);
			map.put("status", 200);
			map.put("result", ret); //있으면 참, 없으면 거짓

		} catch (Exception e) {
			map.put("status", -1);
			map.put("result", e.getMessage());
		}
		return map;
	}


	@PostMapping(value="/join.json")
	public Map<String, Object> joinPOST(@RequestBody MemberDto memberDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("memberDto", memberDto);
		System.out.println(memberDto.getMemberId());
		try {
			Member member = Member.createMember(memberDto);
			memberService.saveMember(member);
			System.out.println("==============저장됐니?");
		}
		catch(Exception e) {
			map.put("status", -1);
			map.put("result", e.getMessage());
		}
		return map;
	}

	@PostMapping(value = "login.json")
	public void login() {
		LOG.info("GET successfully called on /login resource");
	}

}
