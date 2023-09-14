package com.noej.aug081j.snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class SnackDAO {
	
	@Autowired
	private SnackRepo sr;
	
	public void get(HttpServletRequest req) {
			req.setAttribute("snacks", sr.findAll());
	}

	public void reg(Snack s, HttpServletRequest req) {
		try {
			sr.save(s);
			req.setAttribute("result", "등록성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
	}
	
}
