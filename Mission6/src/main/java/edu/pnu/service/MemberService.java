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
	

	public List<Member> getMembers() {
		return memberRepo.findAll();
	}

	public Member getMember(Integer id) {
		return memberRepo.findById(id).get();
	}
	
	
}
