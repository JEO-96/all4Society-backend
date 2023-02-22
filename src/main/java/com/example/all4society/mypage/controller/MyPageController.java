package com.example.all4society.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.all4society.Member;
import com.example.all4society.MemberRepository;
import com.example.all4society.member.MemberDto;
import com.example.all4society.mypage.service.MyPageService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8082/")
public class MyPageController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MyPageService myPageService;
	
	@GetMapping("/myPage")
	public List<Member> myPage(HttpSession session) {
		String userId = (String) session.getAttribute("sessionId");
		return memberRepository.findAllByMemberId(userId);
	}
	
	@PostMapping(value="/myPageModify.json")
	public Map<String, Object> myPageModify(@RequestBody MemberDto memberDto, HttpSession session) {
		String userId = (String) session.getAttribute("sessionId");
		Map<String, Object> map = new HashMap<>();
		map.put("memberDto", memberDto);
		try {
			myPageService.infoModify(memberDto, userId);
		}
		catch (Exception e) {
			map.put("status", -1);
			map.put("result", e.getMessage());
		}return map;
	}
}
