package com.noej.aug18rbe2.mp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyPhotoController {

	@Autowired
	private MyPhotoDAO mpDAO;
	
	// get : 그냥 주소에
	// post : 내부적 -> 보안이 강화
	
	@RequestMapping(value = "/photo.upload", produces = "application/json;charset=utf-8")
	public @ResponseBody MyPhoto photoUpload(@RequestParam("file2") MultipartFile mf, MyPhoto mp, HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		res.addHeader("Access-Control-Allow-Credentials", "true");
		return mpDAO.upload(mf, mp);
	}

	@RequestMapping(value = "/photo.get", produces = "application/json;charset=utf-8")
	public @ResponseBody MyPhotos photoGet(HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mpDAO.get();
	}

	@RequestMapping(value = "/photo/{name}")
	public @ResponseBody Resource getPhoto(@PathVariable("name") String name) {
		return mpDAO.getPhoto(name);
	}
}
