package com.noej.aug041f.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileController {
	
	@Autowired
	private FileDAO fDAO;
	
	@RequestMapping("/file.upload")
	public String fileUpload(@RequestParam("imgg") MultipartFile mf, @RequestParam("etcc") MultipartFile[] mfs, NoejFile nf, HttpServletRequest req) {
		fDAO.upload(mf, mfs, nf, req);
		return "output";
	}
	
	// 주소로 요청하면 파일이 나오게
	@RequestMapping("/img/{n}")
	public @ResponseBody Resource getImg(@PathVariable("n") String name) {
		return fDAO.getImg(name);
	}

	@RequestMapping("/download/{n}")
	public ResponseEntity<Resource> getFile(@PathVariable("n") String name) {
		return fDAO.getFile(name);
	}
}
