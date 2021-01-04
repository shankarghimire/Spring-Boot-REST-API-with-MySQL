package com.examples.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	//For StaticStatic File Path
	//public final String UPLOAD_DIR="E:\\Sheridan\\Java-Practice\\Spring-Boot-REST-API-with-MySQL\\src\\main\\resources\\static\\documents";
	
	//For Dynamic File Path
	public final String UPLOAD_DIR = new ClassPathResource("static/documents/").getFile().getAbsolutePath();
	
	
	public FileUploadHelper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean uploadFile(MultipartFile file) {
		boolean status = false;
		try {
			//Method I:
//			InputStream inputStream = file.getInputStream();
//			byte data[] = new byte[inputStream.available()];
//			inputStream.read();
//			
//			//Write file
//			FileOutputStream fos = new FileOutputStream( UPLOAD_DIR + File.separator + file.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
			//Method II:
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING );
			
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}
}
