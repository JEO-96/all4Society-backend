package com.example.all4society;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String>{
	boolean existsByMemberId(String id);
	Member findByMemberId(String memberId);

	@Query(value = "SELECT member_id FROM member WHERE member_id = :id and member_answer = :answer", nativeQuery = true)
	Member findByMemberId_Answer(String id, String answer);

	@Query(value = "SELECT * FROM member WHERE member_name = :name AND member_phone = :phone", nativeQuery = true)
	Member findByMemberNameAndMemberPhone(String name, String phone);
}
