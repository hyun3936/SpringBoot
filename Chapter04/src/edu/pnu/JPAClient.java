package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {
	
	private static void insertData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
		} catch(Exception e) {
			System.out.println("Error:" + e.getMessage());
			tx.rollback();
		}
		
		
	}
	
	private static void searchData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		try {
			//  게시물 조회
			Board board = em.find(Board.class, 1L);
			if (board != null) System.out.println("Search:" + board);
			else			System.out.println("Not Found");
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	
	private static void modifyData(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		try {
			//  게시물 조회
			Board board = em.find(Board.class, 1L);
			if (board != null) System.out.println("Search:" + board);
			else			System.out.println("Not Found");
		}catch(Exception e){
			e.printStackTrace();
			
		} finally {
			em.close();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		//EntityManagerFactory생성
		
		//검색
		
		//수정
		
		
		
		
		
		
//		// EntityManager 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		// Transcation 생성
//		EntityTransaction tx = em.getTransaction();
//		
//		try {
//			// Transaction 시작
//			tx.begin();
//			
//			Board board = new Board();
//			board.setTitle("TPA 제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 되네요");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//
//			// 글 등록
//			em.persist(board);
//			
//			// Transaction commit
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// Transaction rollback
//			tx.rollback();
//		} finally {
//			em.close();
//			emf.close();
//		}
	}
}
