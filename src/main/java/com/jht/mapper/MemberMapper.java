package com.jht.mapper;

// 정적 배열보다는 동적 배열이 메모리상이나 사용상에서의 이점이 있어,
// 정적 배열을 쓰는 것보다 동적 배열을 생성하여 활용해주는 것이 확실히 좋다

import java.util.ArrayList;

import com.jht.model.MemberDTO;

public interface MemberMapper {
	public void write(MemberDTO member);

	public ArrayList<MemberDTO> list();
	// ArrayList는 MemberDTO의 리턴타입이 되므로 따로 객체 생성을 해주지 않아도 된다

	public MemberDTO detail(MemberDTO member);

	public MemberDTO login(MemberDTO member);

	public void modify(MemberDTO member);

	public void remove(MemberDTO member);
}
