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
	
	@Column(name="boardCategory")
	private String boardCategory;
	
	@Column(name="boardPlace")
	private String boardPlace;
	
	@Column(name="boardTime")
	private String boardTime;
	
	@Column(name="boardMoney")
	private String boardMoney;
	
	@Column(name="boardCondition")
	private String boardCondition;
	
	@Column(name="boardSubIntro")
	private String boardSubIntro;
	
	@Column(name="boardManagerPhone")
	private String boardManagerPhone;

	public static Board createboard(BoardDto boardDto) {
		Board board = new Board();
		
		board.setBoardName(boardDto.getBoardName());
		board.setBoardIntro(boardDto.getBoardIntro());
		board.setBoardManagerName(boardDto.getBoardManagerName());
		board.setBoardPeople(boardDto.getBoardPeople());
		board.setBoardCategory(boardDto.getBoardCategory());
		board.setBoardCondition(boardDto.getBoardCondition());
		board.setBoardMoney(boardDto.getBoardMoney());
		board.setBoardTime(boardDto.getBoardTime());
		board.setBoardSubIntro(boardDto.getBoardSubIntro());
		board.setBoardPlace(boardDto.getBoardPlace());
		board.setBoardManagerPhone(boardDto.getBoardManagerPhone());
		return board;
	}
}
