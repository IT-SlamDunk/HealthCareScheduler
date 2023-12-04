package com.jht.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jht.model.BoardDTO;



public interface BoardService {

   public ArrayList<BoardDTO> boardlist(BoardDTO list);
   public void boardwrite(BoardDTO write);
}
