package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.pnu.domain.Board;
import edu.pnu.persistance.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	

	// 데이터들을 불러와서 컨트롤러에 전달
	public List<Board> getBoardList(){
		return boardRepo.findAll();
	}


	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
		//객체가 아니라 옵션을 리턴 -> 그래서 뒤에 get을 붙여줌.
	}


	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
//	public void hello(Model model) {
//		return BoardRepo.
//	}
	
	
}
