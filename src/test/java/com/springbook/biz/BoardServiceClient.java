package com.springbook.biz;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); // 싱글톤 패턴임
		BoardService boardService = (BoardService)container.getBean("boardService");
		
//		BoardVO bVo = new BoardVO();
		
//		insert구문 테스트
//		bVo.setTitle("임시제목");
//		bVo.setWriter("홍길동");
//		bVo.setContent("테스트 내용...");
//		boardService.insertBoard(bVo);
		
//		boardList구문 테스트
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println("===>" + board.toString());
		}
		
		container.close();
		
		
	}

}
