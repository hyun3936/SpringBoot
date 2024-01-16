package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BoardVO;

@RestController
public class BoardController2 {

	private List<BoardVO> list;

	public BoardController2() {
		System.out.println("===> BoardController2 생성");

		list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			BoardVO b = new BoardVO();
			b.setSeq(i);
			b.setTitle("제목" + i);
			b.setWriter("테스터");
			list.add(b);
		}
	}

	// localhost:8080/getBoard2?seq=2
	@GetMapping("/getBoard2")
	public BoardVO getBoard(Integer seq) {
		// 아이디가 1보다 작거나 10보다 크면 null을 리턴한다.
		// (seq < 1 || 10 < seq) return null;
		
		// list에 저장된 BoardVO 객체에서 seq 값이 파라미터 seq와 같은 객체를 리턴한다.
		// 그러기 위해서는 list를 처음부터 끝까지 순회하면서 같은 데이터가 있는지 검색한다.
			//for (int i=1; i< list.size(); i++) {
			for(BoardVO b : list) if (b.getSeq() == seq) return b;		
		return null;
	}
	
	
	// localhost:8080/getBoard3/10
	@GetMapping("/getBoard3/{seq}")
	public BoardVO getBoard2(@PathVariable Integer seq) {
		return getBoard(seq);
	}
	

}
