package com.noej.aug21rbe3.student;

import java.time.Duration;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class StudentDAO {
	// 32자리 이상
	private static final String KEY = "0123456789012345678901234567890123456789";

	public StudentToken makeToken(Student s) {
		try {
			Date now = new Date();
			// 현재 시간으로부터 10초뒤
			Date expiration = new Date(now.getTime() + Duration.ofSeconds(10).toMillis());
			String token = Jwts.builder().signWith(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).setExpiration(expiration)
					.claim("name", s.getName()).claim("age", s.getAge()).compact();
			System.out.println(token);
			return new StudentToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Student getStudent(String token) {
		try {
			JwtParser jp = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).build();
			Jws<Claims> cs = jp.parseClaimsJws(token);
			Claims c = cs.getBody();
			String n = (String) c.get("name");
			int a = (Integer) c.get("age");
			
			return new Student(n, a);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public StudentToken update(String token) {
		try {
			JwtParser jp = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).build();
			Jws<Claims> cs = jp.parseClaimsJws(token);
			Claims c = cs.getBody();
			
			Date now = new Date();
			Date expiration = new Date(now.getTime() + Duration.ofSeconds(10).toMillis());
			
			String token2 = Jwts.builder()
					.signWith(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).setExpiration(expiration)
					.claim("name", c.get("name")).claim("age", c.get("age")).compact();
			return new StudentToken(token2);
		} catch (Exception e) {
			e.printStackTrace();
			return new StudentToken("없음");
		}
	}
}
