package com.noej.aug041f.file;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class FileDAO {
	
	@Value("${file.dir}")
	private String fileDir;

	// 이미지, 영상, ...
	public Resource getImg(String name) {
		try {
			return new UrlResource("file:" + fileDir + "/" + name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 다운받게
	public ResponseEntity<Resource> getFile(String name) {
		try {
			UrlResource ur = new UrlResource("file:" + fileDir + "/" + name);
			String header = "attachment; filename=\"" + URLEncoder.encode(name, "utf-8") + "\"";
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, header).body(ur);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getFileName(MultipartFile mf) {

		// 파일명 중복되면 그냥 덮어쓰기
		// 안덮어쓰려면 파일명을 다르게 해야
		// 그 대책은 없어서 직접 뒤에 숫자를 붙이던가 해야
		String fileName = mf.getOriginalFilename(); // ㅋ ㅋ.png
		String type = fileName.substring(fileName.lastIndexOf(".")); // .png
		fileName = fileName.replace(type, ""); // ㅋ ㅋ
		
		// UUID : 네트워크같은데서 중복안되는 ID값 필요할때 쓰는
		String uuid = UUID.randomUUID().toString();
		return fileName + "_" + uuid + type;
	}
	
	public void upload(MultipartFile mf, MultipartFile[] mfs, NoejFile nf, HttpServletRequest req) {
		try {
			String fileName = getFileName(mf);
			File f = new File(fileDir + "/" + fileName);
			mf.transferTo(f); // 실제 업로드
			nf.setImg(fileName);

			ArrayList<String> fileNames = new ArrayList<>();
			String fileName2 = null;
			File f2 = null;
			for (MultipartFile mff : mfs) {
				fileName2 = getFileName(mff);
				f2 = new File(fileDir + "/" + fileName2);
				mff.transferTo(f2); // 실제 업로드
				fileNames.add(fileName2);
			}
			nf.setEtc(fileNames);
			
			req.setAttribute("nf", nf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
