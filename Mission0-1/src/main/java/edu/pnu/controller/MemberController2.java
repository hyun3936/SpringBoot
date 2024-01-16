package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController2 {
	
	private List<MemberVO> list;
	
	public MemberController2() {
		list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			MemberVO m = new MemberVO();
			m.setId(i);
			m.setName("name" + i);
			m.setPass("pass" + i);
			m.setRegidate(new Date());
			
			list.add(m);	
		}
	}
	
	@GetMapping("/member33")
	public List<MemberVO> getMembers() {
		return list;
	}
	
	@GetMapping("/member33/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) return m;
		}
		return null;
	}
	
	@PostMapping("/member33")
	public int addMember(MemberVO memberVO) {
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
}
