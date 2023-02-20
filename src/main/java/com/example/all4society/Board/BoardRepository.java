package com.example.all4society.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>{
	boolean existsByBoardName(String boardName);
	
	Board findBoardByBoardName(String boardName); // 특정 게시물 확인
	
	@Query(value = "SELECT COUNT(*) FROM all4board " , nativeQuery = true)
    int countAllByBoard(); // 게시글 총 개수
	
	@Query(value = "SELECT * FROM all4board " , nativeQuery = true)
	Board getBoardAll(); // 전체 게시물 보여주기
}
