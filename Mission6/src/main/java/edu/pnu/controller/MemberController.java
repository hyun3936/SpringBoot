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

import edu.pnu.domain.Member;


@RestController
public class MemberController {

	private List<Member> list;

	public MemberController() {
		System.out.println("===> MemberController 생성");

		list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(Member.builder()
					.id(i)
					.name("name" + i)
					.pass("pass" + i)
					.regidate(new Date())
					.build());
			
//			MemberVO m = new MemberVO();
//			m.setId(i);
//			m.setName("이름" + i);
//			m.setPass("패스");
//			m.setRegidate(new Date());
//			list.add(m);
		}
	}
	
	// ex) http://localhost:8080/member
	@GetMapping("/member")
	public List<Member> getMembers(){
		return list;	
	}
	
	
	// ex) http://localhost:8080/member/10
	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable Integer id) {
		for(Member m : list) {
			if (m.getId() == id) {
				return m;	
			}
		}
		return null;
	}
	
	private Member getMember(Member member) {		
		for(Member m: list) if (m.getId() == member.getId()) return m;
		return null;
	}
	
	
	// /member 주소가 같아도 되는게 get 방식이면 get 메소드 post방식이면 post 메소드 호출
	// 둘다 호출은 request 매핑
	
	private boolean isExistMember(Member member) {
		for (Member m: list) {
			if (m.getId() == member.getId()) return true;
		}
		return false;
	}
	
	@PostMapping("/member") 
	public int addMember(Member member) {
		if (isExistMember(member))	return 0;
		member.setRegidate(new Date());
		list.add(member);
		return 1;
	}

	@PostMapping("/memberJSON") 
	public int addMemberJSON(@RequestBody Member member) {
		if (isExistMember(member))	return 0;
		member.setRegidate(new Date());
		list.add(member);
		return 1;
	}
	
	@PutMapping("/member")
	public int updateMembers(Member member) {
		Member m = getMember(member);
		if(m == null) return 0;
		m.setName(member.getName());
		m.setPass(member.getName());
		return 1;
	}
	
	@DeleteMapping("/member") // 파라미터로 받아서 하는 방법
	public int removeMember(@PathVariable Integer id) {
//		MemberVO m = getMember(id);
//		if (m != null) list.remove(m);
		
		try {
		list.remove(getMember(id));
		} catch(Exception e) {}
		
		return 1;
	}
	
}
