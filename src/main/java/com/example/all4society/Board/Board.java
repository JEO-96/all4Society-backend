package com.example.all4society.Board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "All4board")
public class Board {
	

	@Id
	@Column(name="boardName")
	private String boardName;
	
	@Column(name="boardIntro")
	private String boardIntro;
	
	@Column(name="boardManagerName")
	private String boardManagerName;
	
	@Column(name="boardPeople")
	private String boardPeople;
	
	public static Board createboard(BoardDto boardDto) {
		Board board = new Board();
		board.setBoardName(boardDto.getBoardName());
		board.setBoardIntro(boardDto.getBoardIntro());
		board.setBoardManagerName(boardDto.getBoardManagerName());
		board.setBoardPeople(boardDto.getBoardPeople());
		return board;
	}
}
