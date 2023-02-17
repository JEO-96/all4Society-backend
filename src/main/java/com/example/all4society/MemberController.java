package com.example.all4society;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/member")
@RequiredArgsConstructor
public class MemberController {
	
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
        System.out.println(memberDto);
        try {
//        	Member member = Member.createMember(memberDto);
//        	memberService.saveMember(member);
//            System.out.println("==============저장됐니?");
        }
        catch(Exception e) {
            map.put("status", -1);
            map.put("result", e.getMessage());
        }
        return map;
    }
	
}
