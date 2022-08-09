package com.spring.biz.board.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.springbook.biz.board.BoardVO;

public class BoardDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void insertBoard() {
		
	}
	public void updateBoard() {
		
	}
	public void deleteBoard() {
		
	}
	public BoardVO getBoard() {
		return null;
	}
	
	public List<BoardVO> getBoardList(){
		return null;
		
	}

}
