package com.example.all4society.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.example.all4society.Member;
import com.example.all4society.dto.member.MemberDto;
import com.example.all4society.MemberRepository;
import com.example.all4society.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@PostMapping(value = "/login")
	public Map<String, Object> login(@RequestBody MemberDto memberDto, Model model, HttpServletRequest request, HttpSession session) {

		Map<String, Object> map = new HashMap<>();
		map.put("memberDto", memberDto);
		System.out.println(memberDto.getMemberId());
		Member member = memberRepository.findByMemberId(memberDto.getMemberId());

		if (member.getMemberPw().equals(memberDto.getMemberPw())){
			map.put("status", 200);
			session.setAttribute("sessionId", memberRepository.getById(member.getMemberId())); // 세션값 등록
			model.addAttribute("sessionId", session.getAttribute("sessionId"));
		} else {
			map.put("status", -1);
		}
		return map;
	}

	@GetMapping("/findId")
	public Member fineId(@RequestBody MemberDto memberDto){
		System.out.println("아이디 찾기");
		Member member = memberRepository.findByMemberNameAndMemberPhone(memberDto.getMemberName(), memberDto.getMemberPhone());
		System.out.println("아이디 찾음");
		return member;
	}


}
