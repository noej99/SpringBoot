package com.noej.aug082ss.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

// PW를 DB에 그냥 저장하면...
// v DBA가 암호화되서 저장하게 서버세팅을 하니까

// SpringSecurity자체로 암호화기능이 있어서 소개
//		암호화 한거를 원상복구 가능한 알고리즘
//		암호화 한거를 원상복구 불가능한 알고리즘 - v

@Service
public class MemberDAO {
	private BCryptPasswordEncoder bcpe;
	
	public MemberDAO() {
		bcpe = new BCryptPasswordEncoder();
	}
	
	public void login(Member m, HttpServletRequest req) {
		Member dbMember = new Member("test", bcpe.encode("1234"));
		
		System.out.println(m.getId());
		System.out.println(m.getPw());
		System.out.println(bcpe.encode(m.getPw())); // 암호화
		System.out.println(bcpe.matches(m.getPw(), dbMember.getPw())); // 평문, 암호문 같은지 검사
		if (bcpe.matches(m.getPw(), dbMember.getPw())) {
			System.out.println("성공");
		}
	}
	
}
