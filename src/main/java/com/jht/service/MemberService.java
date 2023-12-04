package com.jht.service;
// 세션값은 컨트롤러에 넣든, 서비스에 넣든 상관이 없다


import java.util.ArrayList;

import com.jht.model.MemberDTO;

// 인터페이스에서는 상수나 추상 메서드만 사용이 가능하다

public interface MemberService {

	// 회원가입
	public void write(MemberDTO member);

	// 회원정보 수정
	public void modify();

	
	public void remove(MemberDTO member);


	// 회원목록 조회 (관리자)
	public ArrayList<MemberDTO> list();
	
	public void modify(MemberDTO member);

	// 회원목록의 회원정보 상세조회 (관리자)
	public MemberDTO detail(MemberDTO member);
	
	// 로그인
	public MemberDTO login(MemberDTO member);
	
	}



