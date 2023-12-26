package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

// DAO(Data Access Object)
@Repository
public class BoardDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		final String SQL = "INSERT INTO BOARD(TITLE, WRITER, CONTENT) VALUES(?,?,?)";
		jdbcTemplate.update(SQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		final String SQL = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
		jdbcTemplate.update(SQL, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		final String SQL = "DELETE FROM BOARD WHERE SEQ=?";
		jdbcTemplate.update(SQL, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		final String SQL = "SELECT * FROM BOARD WHERE SEQ=?";
		return jdbcTemplate.queryForObject(SQL, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		final String SQL = "SELECT * FROM BOARD ORDER BY SEQ DESC";
		return jdbcTemplate.query(SQL, new BoardRowMapper());
	}
}

