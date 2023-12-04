package com.jht.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jht.model.BoardDTO;
import com.jht.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper bm;

	public ArrayList<BoardDTO> boardlist(BoardDTO list) {
		return bm.boardlist(list);
	};

	public void boardwrite(BoardDTO write) {
		bm.boardwrite(write);
	};
}