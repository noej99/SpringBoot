package com.noej.aug081j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noej.aug081j.company.CompanyDAO;
import com.noej.aug081j.snack.SnackDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@Autowired
	private SnackDAO sDAO;
	
	@Autowired
	private CompanyDAO cDAO;
	
	@RequestMapping("/")
	public String home(HttpServletRequest req) {
		sDAO.get(req);
		cDAO.get(req);
		return "index";
	}
}
