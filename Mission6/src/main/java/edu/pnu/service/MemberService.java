package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistance.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
	// 데이터들 전부 불러옴
	public List<Member> getMembers() {
		return memberRepo.findAll();
	}

	// 데이터 내가 원하는 것만 id로 검색해서 가져옴
	public Member getMember(Integer id) {
		return memberRepo.findById(id).get();
	}

	// 데이터 추가
	public Member add(Member member) {
		return memberRepo.save(member);
	}

	// 데이터를 수정할껀데 네임만 수정할 수도 있고, 패스만 수정 할 수 있다.
	// 그런데 하나만 수정했을 때 나머지가 null로 되면 안되고 원래값을 유지하도록
	
	// 데이터 수정 (ex. id=2, name=홍길동)
	public Member update(Member member) {
		 // 겟멈버 해서 일단 불러 온다음에 
		 Member m = getMember(member.getId()); //(id값은 있는거 입력해줘야 그다음이 수정됨.)
		 // 내가 수정할 부분만 변경
		if (member.getName() != null)
				m.setName(member.getName());
		if (member.getPass() != null)
				m.setPass(member.getPass());
		if (member.getRole() != null)
				m.setRole(member.getRole());

		return memberRepo.save(m);
	}

	public Integer delete(Integer id) {
			try {
				if (memberRepo.existsById(id) ) {
					memberRepo.deleteById(id);
					return 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
	}
}