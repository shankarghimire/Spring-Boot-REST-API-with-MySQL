package com.examples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examples.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uplloadFile(@RequestParam("file") MultipartFile file){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contanin valid file");
			}
			
			if(!file.getContentType().equals("application/pdf")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request File must be PDF format");
			}
			
			//Uploads the file
			boolean uploadResult = fileUploadHelper.uploadFile(file);
			if(uploadResult) {
				//return ResponseEntity.ok("File is successfully uploaded.");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/documents/").path(file.getOriginalFilename()).toUriString());
			}	
		}
		catch(Exception e) {
			
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Try again.");
	}

}
