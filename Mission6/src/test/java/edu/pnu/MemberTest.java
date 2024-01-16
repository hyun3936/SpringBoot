package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistance.MemberRepository;

// 넣고 검색하고 수정하고 딜리트

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	@Order(1)
	@DisplayName("데이터 입력")
	public void testInsertMember() {
		for (int i = 1; i < 6; i++) {
		memberRepo.save(Member.builder()
				.id(i)
				.name("이름" + i)
				.pass("비번" + i + i)
				.regidate(new Date())
				.build());	
		}
	}
//	public void testInsertMember() {
//		Member member = new Member();
//		member.setId(0);
//		member.setName("이름");
//		member.setPass("비번");
//		member.setRegidate(new Date());
//		
//		memberRepo.save(member);
//		이렇게 쓸려면 bulid를 없애야 됨.
//	}
	
//	@Test
//	@Order(2)
//	@DisplayName("검색")
//	public void testGetMember() {
//		Member member = memberRepo.findById(1).get();
//		System.out.println(member.toString());
//	}
//	
//	@Test
//	@Order(3)
//	@DisplayName("수정")
//	public void testUpdateMember() {
//		System.out.println("=== 1번 게시글 조회 ===".repeat(5));
//		Member member = memberRepo.findById(4).get(); // 수정할 인덱스
//		
//		System.out.println("=== 1번 이름 수정 ===".repeat(5));
//		member.setName("이름55"); // 수정할 이름
//		memberRepo.save(member);
//	}
//
//	
//	
//	@Test
//	@Order(4)
//	@DisplayName("삭제")
//	public void testDeleteMemeber() {
//		memberRepo.deleteById(1);
//	}
//	
	
	
	
}
