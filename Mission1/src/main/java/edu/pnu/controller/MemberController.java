package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;


@RestController
public class MemberController {
	
	MemberService m = new MemberService();
	
	
	// ex) http://localhost:8080/member
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return m.getMembers();	
	}
	
	
	// ex) http://localhost:8080/member/10
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return m.getMember(id);
	}
	

	
	@PostMapping("/member") 
	public int addMember(MemberVO memberVO) {
		return m.addMember(memberVO);
	}

	@PostMapping("/memberJSON") 
	public int addMemberJSON(@RequestBody MemberVO memberVO) {
		return m.addMemberJSON(memberVO);
	}
	
	@PutMapping("/member")
	public int updateMembers(MemberVO memberVO) {
		return m.updateMembers(memberVO);
	}
	
	@DeleteMapping("/member") // 파라미터로 받아서 하는 방법
	public int removeMember( Integer id) {
		return m.removeMember(id);
	}
	
}
