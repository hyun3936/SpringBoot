package edu.pnu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDao {
	
	private Connection con; 
	
	public MemberDao(DataSource dataSource) throws SQLException {
		System.out.println("MemberDao 생성");		
		con = dataSource.getConnection();
	}
	
	public List<MemberVO> getMembers() {
		// 겟 멤버를 구현
		
		Statement st = null;
		ResultSet rs = null;  // 결과를 받기 위해
		try {
			// 질의 객체를 만든다. (Statement or PreparedStatement)
			st = con.createStatement();
			
			// ResultSet ==> 커서 생성
			// 질의 실행
			rs = st.executeQuery("SELECT * FROM member ORDER BY id ASC");
			
			//질의 결과를 저장할 리스트 변수 생성
			List<MemberVO> list = new ArrayList<>();
			
			// 커서 프로세싱 (Cursor Processing)
			while(rs.next()) {
				// 실행 결과를 객체로 생성해서 리스트에 저장
				list.add(MemberVO.builder()				
					.id(rs.getInt("id"))
					.name(rs.getString("name"))
					.pass(rs.getString("pass"))
					.regidate(rs.getDate("regidate"))
					.build());
			}
			
			// 최종 결과 리스트 리턴 (리소스 닫기)
			return list;	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) st.close();
				if (rs != null) rs.close();
					
			}catch(Exception e) {}
		}

		return null ;
	}
	
	public MemberVO getMember(Integer id){
		for(MemberVO m : list) {
			if (m.getId() == id) {
				return m;	
			}
		}
		return null;
	}
	
	
	
	
	
	
}
