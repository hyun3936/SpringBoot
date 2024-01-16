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


@RestController
public class MemberController {

	private List<MemberVO> list;

	public MemberController() {
		System.out.println("===> MemberController 생성");

		list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(MemberVO.builder()
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
	public List<MemberVO> getMembers(){
		return list;	
	}
	
	
	// ex) http://localhost:8080/member/10
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		for(MemberVO m : list) {
			if (m.getId() == id) {
				return m;	
			}
		}
		return null;
	}
	
	private MemberVO getMember(MemberVO memberVO) {		
		for(MemberVO m: list) if (m.getId() == memberVO.getId()) return m;
		return null;
	}
	
	
	// /member 주소가 같아도 되는게 get 방식이면 get 메소드 post방식이면 post 메소드 호출
	// 둘다 호출은 request 매핑
	
	private boolean isExistMember(MemberVO memberVO) {
		for (MemberVO m: list) {
			if (m.getId() == memberVO.getId()) return true;
		}
		return false;
	}
	
	@PostMapping("/member") 
	public int addMember(MemberVO memberVO) {
		if (isExistMember(memberVO))	return 0;
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return 1;
	}

	@PostMapping("/memberJSON") 
	public int addMemberJSON(@RequestBody MemberVO memberVO) {
		if (isExistMember(memberVO))	return 0;
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return 1;
	}
	
	@PutMapping("/member")
	public int updateMembers(MemberVO memberVO) {
		MemberVO m = getMember(memberVO);
		if(m == null) return 0;
		m.setName(memberVO.getName());
		m.setPass(memberVO.getName());
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
