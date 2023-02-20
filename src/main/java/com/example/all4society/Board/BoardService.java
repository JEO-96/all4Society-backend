package com.example.all4society.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public Board saveBoard(Board board) {
		return boardRepository.save(board);
	}
	
	public Board getBoard(String boardName) {
		return boardRepository.findBoardByBoardName(boardName);
	}
	
	public int getBoardCount() {
		return boardRepository.countAllByBoard();
	}
	
	public Board getBoardAll() {
		return boardRepository.getBoardAll();
	}
	


}
