package com.example.all4society;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String>{
	boolean existsByMemberId(String id);
	Member findByMemberId(String memberId);

	@Query(value = "SELECT member_id FROM member WHERE member_id = :id and member_answer = :answer", nativeQuery = true)
	Member findByMemberId_Answer(String id, String answer);

<<<<<<< HEAD
	@Query(value = "SELECT * FROM member WHERE member_name = :name AND member_phone = :phone", nativeQuery = true)
	Member findByMemberNameAndMemberPhone(String name, String phone);
	
	List<Member> findAllByMemberId(String userId);
=======
	@Query(value = "SELECT member_id FROM member WHERE member_name = :memberName AND member_phone = :memberPhone", nativeQuery = true)
	Member findByMemberNameAndMemberPhone(String memberName, String memberPhone);

	Member findByMemberPhone(String memberPhone);
>>>>>>> 88deb40 (아이디 찾기 됨)
}
