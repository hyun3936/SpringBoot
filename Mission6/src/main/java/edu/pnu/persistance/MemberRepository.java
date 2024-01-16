package edu.pnu.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Member;
import edu.pnu.domain.Member.MemberBuilder;

public interface MemberRepository extends JpaRepository<Member, Integer > {

	
	
}
