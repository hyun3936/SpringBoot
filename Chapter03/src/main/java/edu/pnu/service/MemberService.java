package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;


@Service
public class MemberService {
	
	private List<MemberVO> list;
	
	@Autowired
	private MemberDao memberDao;
	
	
	public MemberService() {
		System.out.println("MemberService 생성");
	}
	
	public List<MemberVO> getMembers(){
		return memberDao.getMembers();
	}
	
	public MemberVO getMember(Integer id){
		return memberDao.getMember(id);
	}

	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}

	public void addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	public List<MemberVO> addTestMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTestMember1() {
		// TODO Auto-generated method stub
		
	}
	
//	public int addMember(MemberVO memberVO) {
//		return memberDao.
//	}
	
	
}
