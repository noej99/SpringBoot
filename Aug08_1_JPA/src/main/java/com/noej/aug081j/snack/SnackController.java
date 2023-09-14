package com.noej.aug081j.snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noej.aug081j.company.CompanyDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SnackController {
	
	@Autowired
	private SnackDAO sDAO;
	
	@Autowired
	private CompanyDAO cDAO;
	
	@RequestMapping("snack.reg")
	public String snackReg(Snack s, HttpServletRequest req) {
		sDAO.reg(s, req);
		sDAO.get(req);
		cDAO.get(req);
		return "index";
	}
}
