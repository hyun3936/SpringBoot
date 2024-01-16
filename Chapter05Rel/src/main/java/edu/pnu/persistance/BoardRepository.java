package edu.pnu.persistance;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

//	List<Board> findByTitle(String title);
//
//	List<Board> findByContentContainingAndCnt(String searchKeyword);
//
//	
//	
//	Page<Board> findByTitleContaining(String string, Pageable paging);
//	
//	List<Board> findByCntGreaterThan(int i);
//	



//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC") // board는 클래스
//	List<Board> queryAnnotationTest1(String searchKeyword);
	
//	@Query("SELECT b FROM Board b "
//			+ "WHERE b.title like %:searchKeyword% "
//			+ "ORDER BY b.seq DESC")
//			List<Board> queryAnnotationTest1(@Param("searchKeyword")String searchKeyword);
//	
//	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
//			+ "FROM Board b "
//			+ "WHERE b.title like %?1% "
//			+ "ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	

}	







