package com.jht.mapper;

import java.util.ArrayList;

import com.jht.model.BoardDTO;

public interface BoardMapper {
	   public ArrayList<BoardDTO> boardlist(BoardDTO list);
	   public void boardwrite(BoardDTO write);
}




/*	// 글쓰기에 해당되는 DB작업 설계
	// 게시글 목록 리스트에 해당되는 DB작업 설계
	// 목록리스트에서 제목을 클릭한 후 상세내용을 조회하는 DB작업 설계
	// 목록리스트에서 제목을 클릭한 후 상세내용을 조회할 때 조회수도 같이 update하는 DB 작업 설계
	// 상세내용에 해당되는 내용을 수정하는 DB설계 작업
	// 상세내용에 해당되는 내용을 삭제하는 DB설계 작업
	// board테이블 전체건수 DB설계
}
*/