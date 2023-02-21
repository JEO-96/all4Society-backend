package com.example.all4society.Board;

import lombok.RequiredArgsConstructor;

import java.util.List;

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
	
	public List<Board> getBoardAll() {
		return boardRepository.findAll();
	}
	
	public List<Board> getBoardStudy(){
		return boardRepository.getBoardStudy();
	}
	
	public List<Board> getBoardTrip(){
		return boardRepository.getBoardTrip();
	}
	
	public List<Board> getBoardSport( ){
		return boardRepository.getBoardSport();
	}
	public List<Board> getBoardMusic( ){
		return boardRepository.getBoardMusic();
	}
	


}
