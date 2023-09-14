package com.noej.aug031t.calc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.noej.aug031t.snack.Snack;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class Calculator {
	
	public void calculate(CalcResult cr, HttpServletRequest req) {
		
		cr.setHab(cr.getX() + cr.getY());
		cr.setCha(cr.getX() - cr.getY());
		cr.setGob(cr.getX() * cr.getY());
		cr.setMoks(cr.getX() / cr.getY());
		req.setAttribute("cr", cr);
		
		req.setAttribute("a", "ㅋㅋㅋ");
		
		ArrayList<Snack> snacks = new ArrayList<>();
		snacks.add(new Snack("초코파이", 5000));
		snacks.add(new Snack("빼빼로", 2000));
		req.setAttribute("b", snacks);
		
		HashMap<String, Snack> snacks2 = new HashMap<>();
		snacks2.put("ㄱ", new Snack("새콤달콤", 500));
		snacks2.put("ㄴ", new Snack("포카칩", 3500));
		req.setAttribute("c", snacks2);
		
		req.getSession().setAttribute("d", 45654);
		
		req.setAttribute("e", new Random().nextInt(100));
		
		req.setAttribute("f", 123456789);
		req.setAttribute("g", 12.3456789);
		req.setAttribute("h", new Date());
		req.setAttribute("i", "https://www.naver.com");
	}
}
