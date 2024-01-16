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

	private List<MemberVO> list; // 데이터를 저장할 리스트 생성
	
	public MemberController() { // 밑에서 이용하기 위해 생성자 생성 
		list = new ArrayList<>();
		for (int i = 1 ; i <= 10 ; i++) {
			
			// m 객체 생성
			// 모든 필드 변수는 null - int는 0
			MemberVO m = new MemberVO();
			// 넣어줘야할 데이터 id, name, pass, regidate를 만들어줘야 됨.
			// private이니까 게터,세터를 써야되는데 가져올데이터가 없으니(있으면 게터로 가져옴) 만들어주기 위해 세터를 사용
			m.setId(i);
			m.setName("Name" + i);
			m.setPass("pass" + i);
			m.setRegidate(new Date());

			// 리스트에 저장할 데이터를 넣어줌.
			list.add(m);

		}
	}
	
	@GetMapping("/member") // 이 코드를 사용하기 위해서  MemberController생성자를 만든거
	public List<MemberVO> getMembers() {
		return list;
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) return m;
		}
		return null;
	}

	
	
	
	
	@PostMapping("/member")
	public int addMember(MemberVO memberVO){

		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return 1;
	}
	
	

	
	
	@PutMapping("/member")
	public int updateMembers(MemberVO memberVO) {
		MemberVO m = getMember(memberVO.getId());
		if(m == null) return 0;
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass()); 
		return 1;
	}
	
	@DeleteMapping("/member/{id}") 
	public int removeMember(@PathVariable Integer id) {
		list.remove(getMember(id));
		
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
