package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistance.BoardRepository;
import edu.pnu.persistance.DynamicBoardRepository;

@SpringBootTest
public class DynamicQueryTest {
	@Autowired
	private DynamicBoardRepository boardRepo;

//	@Test
	public void testDynamicQuery() {
//		String searchCondition = "TITLE";
//		String searchKeyword = "테스트 제목 1";
		String searchCondition = "CONTENT";
		String searchKeyword = "테스트 내용 1";

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		if (searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if (searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}

		Pageable paging = PageRequest.of(0, 5); // 갯수, 인덱스 0에서부터 4까지

		Page<Board> boardList = boardRepo.findAll(builder, paging);

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

	// localhost:8080/boardSearch?title=타이틀10
	// Title이 "%Title1%"인 데이터를 출력
//	@Test
	public void testDynamicQuery1() {
		String searchCondition = "TITLE";
		String searchKeyword = "테스트 제목 1";

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		if (searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if (searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}

		Pageable paging = PageRequest.of(0, 5); // 갯수, 인덱스 0에서부터 4까지

		Page<Board> boardList = boardRepo.findAll(builder, paging);

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

	// cnt가 50보다 큰 데이터를 출력
	@Test
	public void testDynamicQuery2() {

		List<Board> boardList = boardRepo.findByCntGreaterThan(50);

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}

	}

	// 위 1번, 2번에서 데이터를 출력할 때 Page 기능을 추가

//	Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC,"seq");
//	Page<Board> page = boardRepo.findByTitleContaining("1", paging);
//			
//	System.out.println("PageNumber: "+page.getNumber());
//
//	List<Board> list = page.getContent();
//	
//	for(Board b : list)
//		System.out.println(b);

//	@Test
	public void testDynamicQuery3() {

	}

//	@Test
	public void testDynamicQuery4() {

	}

}
