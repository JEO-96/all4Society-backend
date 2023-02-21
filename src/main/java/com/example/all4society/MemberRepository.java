package com.example.all4society;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String>{
	boolean existsByMemberId(String id);
	Member findByMemberId(String memberId);

	@Query(value = "SELECT member_id FROM member WHERE member_id = :id and member_answer = :answer", nativeQuery = true)
	Member findByMemberId_Answer(String id, String answer);
	
	List<Member> findAllByMemberId(String userId);

	@Query(value = "SELECT member_id FROM member WHERE member_name = :memberName AND member_phone = :memberPhone", nativeQuery = true)
	Member findByMemberNameAndMemberPhone(String memberName, String memberPhone);

	Member findByMemberPhone(String memberPhone);

	Member findByMemberIdAndMemberAnswer(String memberId, String memberAnswer);



//	@Query(value = "select * from member where member_email =:memberEmail and member_name =:memberName and member_birth =:memberBirth and member_phone =:memberPhone and member_social = 'N'", nativeQuery = true)
//	Member findPw(@Param ("memberEmail")String memberEmail, @Param ("memberName")String memberName, @Param ("memberBirth")String memberBirth, @Param ("memberPhone")String memberPhone);
}
