package com.springbook.biz;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); // �̱��� ������
		BoardService boardService = (BoardService)container.getBean("boardService");
		
//		BoardVO bVo = new BoardVO();
		
//		insert���� �׽�Ʈ
//		bVo.setTitle("�ӽ�����");
//		bVo.setWriter("ȫ�浿");
//		bVo.setContent("�׽�Ʈ ����...");
//		boardService.insertBoard(bVo);
		
//		boardList���� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println("===>" + board.toString());
		}
		
		container.close();
		
		
	}

}
