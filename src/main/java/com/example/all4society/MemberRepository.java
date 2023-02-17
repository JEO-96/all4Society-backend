package com.example.all4society;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
	boolean existsByMemberId(String id);
}
