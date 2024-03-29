package edu.pnu;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("0번째 게시글");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	
	@Test
	public void testQueryAnnotationTest2() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");
		
		System.out.println("검색 결과");
		for (Object[] row : boardList) {
			System.out.println("---> " + Arrays.toString(row));
		}
	}
	
	
}
