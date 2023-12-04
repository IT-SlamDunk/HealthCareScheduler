package com.jht.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jht.mapper.MemberMapper;
import com.jht.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mm;

	// 회원가입
	public void write(MemberDTO member) {
		// 회원가입 되게
		mm.write(member);

	}

	// 회원정보 수정
	public void modify() {
		// 회원정보 수정
	}
	public void remove(MemberDTO member) {
		mm.remove(member);
	}

	// 회원목록 조회 (관리자)
	public ArrayList<MemberDTO> list() {
		// 회원목록 열람
		return mm.list();
	}

	// 회원정보 상세조회 (관리자)
	public MemberDTO detail(MemberDTO member) {
		// 회원정보 상세하게 보기
		return mm.detail(member);
	}
	
	public void modify(MemberDTO member) {
		mm.modify(member);
	}
	
	// 로그인
	public MemberDTO login(MemberDTO member) {
		return mm.login(member);
	}
}







