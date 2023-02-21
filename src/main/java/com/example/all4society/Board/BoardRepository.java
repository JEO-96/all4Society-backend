package com.example.all4society.Board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>{
	boolean existsByBoardName(String boardName);
	
	Board findBoardByBoardName(String boardName); // 특정 게시물 확인
	
	@Query(value = "SELECT COUNT(*) FROM all4board " , nativeQuery = true)
    int countAllByBoard(); // 게시글 총 개수
	
	@Query(value = "SELECT * FROM all4board " , nativeQuery = true)
	Board getBoardAll(); // 전체 게시물 보여주기
	
	@Query(value = "SELECT * FROM all4board where board_category='스터디'" , nativeQuery = true)
	List<Board> getBoardStudy(); // 스터디 게시물 보여주기

	@Query(value = "SELECT * FROM all4board where board_category='스포츠'" , nativeQuery = true)
	List<Board> getBoardSport(); // 스터디 게시물 보여주기

	@Query(value = "SELECT * FROM all4board where board_category='음악'" , nativeQuery = true)
	List<Board> getBoardMusic(); // 스터디 게시물 보여주기

	@Query(value = "SELECT * FROM all4board where board_category='여행'" , nativeQuery = true)
	List<Board> getBoardTrip( ); // 스터디 게시물 보여주기
	
}
