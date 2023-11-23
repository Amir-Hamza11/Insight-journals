package com.ij.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ij.helper.FileUploadHelper;

@RestController
@RequestMapping("/upload")
@CrossOrigin("*")
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/image")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
//		
		
		try {
			
		
		//VALIDATION:
		if(file.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Request must contain file");
		}
		
//		if(!file.getContentType().equals("image/jpeg") || !file.getContentType().equals("image/webp")  ) {
//			
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Only JPEG content allowed");
//		}
		
		//FILE UPLOAD CODE:
		
		boolean f = fileUploadHelper.uploadFile(file);
		
		if(f) {
			return ResponseEntity.ok("File uploaded successfully");
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ! Try again");
	}
}
