package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	private BoardDAO dao;
	
	// 게시물 리스트
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}
	
	// 게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}
	
	// 게시물 상세보기
	@Override
	public BoardVO view(int bno) throws Exception {
		log.info("serviceImpl >>>>>>>" + dao.view(bno) );
		return dao.view(bno);
	}
	
	// 게시물 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.modify(vo);
	}
	
}