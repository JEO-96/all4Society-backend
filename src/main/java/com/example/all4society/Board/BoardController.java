package com.example.all4society.Board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/board")
@RequiredArgsConstructor
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardService boardService;

	@GetMapping(value="/boardcheck.json")
	public Map<String, Object> idCheckGET(@RequestParam(name="boardName") String boardName) {
		System.out.println(boardName);
		Map<String, Object> map = new HashMap<>();
		try {
			boolean ret = boardRepository.existsByBoardName(boardName);
			map.put("status", 200);
			map.put("result", ret); //있으면 참, 없으면 거짓

		} catch (Exception e) {
			map.put("status", -1);
			map.put("result", e.getMessage());
		}
		return map;
	}


	@PostMapping(value="/register.json")
	public Map<String, Object> boardRegister(@RequestBody BoardDto boardDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardDto", boardDto);
		System.out.println(boardDto.getBoardName());
		try {
			boardService.saveBoard(Board.createboard(boardDto));
			System.out.println("======board=======");
		}
		catch(Exception e) {
			map.put("status", -1);
			map.put("result", e.getMessage());
		}
		return map;
	}
	
	@GetMapping(value="/register.json")
	public String boardRegisterGo() {
		return "redirect:";
	}
	
	@GetMapping(value="/getBoard.json")
	public Board getBoard(String boardName) {
		return boardService.getBoard(boardName);
	}
	
	@GetMapping(value="/board.json")
	public Board getAllBoard() {
		return boardService.getBoardAll();
	}
	

}
