package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
/*
 * 기본형 데이터 타입 : int, short, long, double, float, char, byte, boolean
 * 참조형 데이터 타입 : Integer, Short, Long, Double, Float, Char, Byte, Boolean
 * 
 	1.public ResponseEntity<?> getMember(int id)
 	2.public ResponseEntity<?> getMember(Integer id)
		==> @GetMapping("/member")
 		==> http://localhost:8080/member?id=3 ==> 파라미터로 데이터를 받는다.
 		==> 2번을 써야 하는 이유: 객체형 변수를 사용하여야 null 값을 받을 수 있다.
 	
	3.public ResponseEntity<?> getMember(@PathVariable Integer id)
		==> @GetMapping("/member/{id}")
 		==> http://localhost:8080/member/3
 */
	
	@GetMapping("/member")
	public ResponseEntity<?> getMember(Integer id){
		if (id == null)
			return ResponseEntity.ok(memberService.getMembers());
		return ResponseEntity.ok(memberService.getMember(id));
	}

/*
 	1.public int addMember(Member member)	// form data [*] ==> 객체로 바로 받기
 		==> http://localhost:8080/member
 		==> Form Parameter : id:100, name:name100 ... ==> 폼 파라미터로 데이터를 받는다.
 	
 	2.public int addMember(@RequestBody Member member)
 		==> http://localhost:8080/member
 		==> @RequestBody : Data를 JSON으로 받겠다. Body->raw->JSON
 */
	
	@PostMapping("/member")
	public ResponseEntity<?> addMember(@RequestBody Member member) {
		return ResponseEntity.ok(memberService.add(member));
	}
//	
//	@PutMapping("/member")
//	public int updateMembers(Member member) {
//		Member m = getMember(member);
//		if(m == null) return 0;
//		m.setName(member.getName());
//		m.setPass(member.getName());
//		return 1;
//	}
//	
//	@DeleteMapping("/member/{id}") // 파라미터로 받아서 하는 방법
//	public int removeMember(@PathVariable Integer id) {
//		Member m = getMember(id);
//		if (m != null) list.remove(m);
//		
//		try {
//		list.remove(getMember(id));
//		} catch(Exception e) {}
//		
//		return 1;
//	}
	
}
