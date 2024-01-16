package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
//	@GetMapping("/member")
//	public List<Member> getMembers(){
//		return memberService.getMembers();
//	}
//	
//	@GetMapping("/member/{id}")
//	public List<Member> getMember(@PathVariable Long id){
//		return memberService.getMembers(id);
//	}
	
	@GetMapping("/member")
	public ResponseEntity<?> getMember(Integer id){
		if (id == null)
			return ResponseEntity.ok(memberService.getMembers());
		return ResponseEntity.ok(memberService.getMember(id));
	}
	
	
	
	
}
