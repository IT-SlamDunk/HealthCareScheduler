package com.jht.model;

public class MemberDTO {
	
//	DB 테이블의 레코드에 자바빈의 내용을 싣는다
	
	private String id; // 보안상 private 제한자로 생성
	private String pw;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
}



