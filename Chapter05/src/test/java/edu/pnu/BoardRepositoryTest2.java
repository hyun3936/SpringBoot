package edu.pnu;


import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest2 {
	@Autowired
	private BoardRepository boardRepo;
	
// 1. 테스트 데이터를 100건 입력 (cnt는 random으로 0~100까지 입	
	@Test	
	@DisplayName("내용 수정")
	public void testInsertBoard() {
		Random rand = new Random();
	 for (int i = 0; i < 100; i++) {		
		Board board = new Board();
		board.setTitle("테스트 제목 "+ i);
		board.setWriter("테스터");
		board.setContent("테스트 내용 "+ i);
		board.setCreateDate(new Date());
		board.setCnt(rand.nextLong(101L));
		
		boardRepo.save(board);
	 }
	}
	
// 2. title에 "1"이 포함되는 데이터 출력
	
//	@Test
	public void testByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
	}
	
// 3. title에 "1"이 포함되면서 cnt가 50보다 큰 데이터 출력
	
//	@Test
//	@Order(1)
	@DisplayName("데이터 검색")
	public void test02() {
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC,"seq");
		Page<Board> page = boardRepo.findByTitleContaining("1", paging);
				
		System.out.println("PageNumber: "+page.getNumber());

		List<Board> list = page.getContent();
		
		for(Board b : list)
			System.out.println(b);
	}
	
	
	
	
}
