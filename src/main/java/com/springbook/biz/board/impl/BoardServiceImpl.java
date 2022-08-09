package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDao;

	@Override
	public void insertBoard(BoardVO vo) {
		bDao.insertBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) {
		bDao.updateBoard(vo);

	}

	@Override
	public void deleteBoard(BoardVO vo) {
		bDao.deleteBoard(vo);

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return bDao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return bDao.getBoardList();
	}

}
