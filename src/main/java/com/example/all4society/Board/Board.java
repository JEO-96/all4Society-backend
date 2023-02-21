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
	@Column(name="board_name")
	private String boardName;
	
	@Column(name="board_intro")
	private String boardIntro;
	
	@Column(name="board_sub_intro")
	private String boardSubIntro;
	
	@Column(name="board_people")
	private String boardPeople;
	
	public static Board createboard(BoardDto boardDto) {
		Board board = new Board();
		board.setBoardName(boardDto.getBoardName());
		board.setBoardIntro(boardDto.getBoardIntro());
		board.setBoardSubIntro(boardDto.getBoardIntro());
		board.setBoardPeople(boardDto.getBoardPeople());
		return board;
	}
}
