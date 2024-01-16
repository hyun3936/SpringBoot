package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberServiceTest {
	
//	@Autowired
//	private MemberService memberService;
	
	MemberService memberService = new MemberService();
	
	@Test
	@Order(0)
	public void test00() {
		for (int i = 100; i < 104; i++)
			memberService.remove(i);
	}
	
	
	
	@Test
	@Order(1)
	@DisplayName("데이터를 입력합니다.")
	public void test01() { 
		for (int i = 100; i <= 104 ; i++)  // 데이터 5개를 만듬
			memberService.addMember(MemberVO.builder()
					.id(i)
					.name("name" + i)
					.pass("pass" + i)
					.regidate(new Date())
					.build());			
	}
	
	@Test
	@Order(2)
	@DisplayName("입력한 데잍러를 읽어 옵니다.")
	public void test02() {
		
		List<MemberVO> list = memberService.addTestMembers();
		for (MemberVO m : list) System.out.println(m);
	}
	
	
	@Test
	@Order(3)
	@DisplayName("데이터를 추가 입력합니다.")
	public void test03() {
		memberService.addTestMember1();
	}
}
