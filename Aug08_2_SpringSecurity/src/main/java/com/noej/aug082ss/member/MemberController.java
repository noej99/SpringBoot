package com.noej.aug082ss.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping("/member.login")
	public String memberLogin(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		return "index";
	}
}
