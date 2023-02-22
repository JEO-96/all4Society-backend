package com.example.all4society.member;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.all4society.Member;
import com.example.all4society.MemberRepository;

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

	@PostMapping(value = "/login")
	public Map<String, Object> login(@RequestBody MemberDto memberDto, Model model, HttpServletRequest request, HttpSession session) {

		Map<String, Object> map = new HashMap<>();
		map.put("memberDto", memberDto);
		System.out.println(memberDto.getMemberId());
		System.out.println(memberDto.getMemberPw());
		System.out.println( memberRepository.login(memberDto.getMemberId(),memberDto.getMemberPw()));
		if ( memberRepository.login(memberDto.getMemberId(),memberDto.getMemberPw())==1){
			map.put("check", 1);
			session.setAttribute("sessionId", memberDto.getMemberId()); // 세션값 등록
			model.addAttribute("sessionId", session.getAttribute("sessionId"));
			return map;
		} else {
			map.put("check", -1);
				System.out.println("로그인 실패");
				return map;
				//ㅇㄹㅇㄹㄷ
		}

	}

	@PostMapping("/findId")
	public Map<String, Object> findId(@RequestBody MemberDto memberDto, HttpSession session){
		System.out.println("아이디 찾기");
		String userid = (String) session.getAttribute("sessionId");
		Map<String, Object> map = new HashMap<>();
		System.out.println(memberDto.getMemberPhone());
		if(memberRepository.findId(memberDto.getMemberPhone())==1) {
			String result = memberRepository.findIdResult(memberDto.getMemberPhone());
			map.put("check", 1);
			map.put("result", result);
			return map;

		}else {
			map.put("check", -1);
			System.out.println("실패");
			return map;
		}

	}

	@PostMapping("/findPw")
	public Map<String,Object> findPw(@RequestBody MemberDto memberDto) {
		System.out.println("비밀번호 찾기");
				Map<String, Object> map = new HashMap<>();
		System.out.println(memberDto.getMemberPhone());
		if(memberRepository.findPw(memberDto.getMemberPhone(),memberDto.getMemberId())==1) {
			String result = memberRepository.findPwResult(memberDto.getMemberPhone(),memberDto.getMemberId());
			map.put("check", 1);
			map.put("result", result);
			return map;

		}else {
			map.put("check", -1);
			System.out.println("실패");
			return map;
		}
	}

//	@PostMapping("/getHint")
//	public Member findHint(@RequestBody MemberDto memberDto) {
//		Member member = memberRepository.findByMemberId(memberDto.getMemberId());
//		return member;
//	}

}
