package com.noej.aug081j.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CompanyDAO {
	
	@Autowired
	private CompanyRepo cr;
	
	public void get(HttpServletRequest req) {
		req.setAttribute("companys", cr.findAll());
	}
}
