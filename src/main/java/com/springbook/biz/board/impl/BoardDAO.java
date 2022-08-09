package com.springbook.biz.board.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String BOARD_INSERT = "INSERT INTO board(seq,title,writer,content) "
			+ "VALUES((SELECT nvl(max(seq),0)+1 FROM board),?,?,?)";
	private final String BOARD_UPDATE = "UPDATE board SET title=?, content=?, WHERE seq = ?";
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq = ?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq = ?";
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq desc";

	public void insertBoard(BoardVO vo) {
		System.out.println("==>I JDBC insertBoard() 扁瓷 贸府");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}

	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC updateBoard() 扁瓷 贸府");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}

	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC deleteBoard() 扁瓷 贸府");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}

	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC getBoard() 扁瓷 贸府");
		BoardVO bVo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bVo = new BoardVO();
				bVo.setSeq(rs.getInt("seq"));
				bVo.setTitle(rs.getString("title"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setContent(rs.getString("content"));
				bVo.setRegdate(rs.getDate("regdate"));
				bVo.setCnt(rs.getInt("cnt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return bVo;
	}

	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC getBoardList() 扁瓷 贸府");
		List<BoardVO> boardList = new ArrayList();

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setSeq(rs.getInt("seq"));
				bVo.setTitle(rs.getString("title"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setContent(rs.getString("content"));
				bVo.setRegdate(rs.getDate("regdate"));
				bVo.setCnt(rs.getInt("cnt"));

				boardList.add(bVo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return boardList;

	}

}
