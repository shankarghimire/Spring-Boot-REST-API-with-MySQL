package com.examples.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//Static File Path
	public final String UPLOAD_DIR="E:\\Sheridan\\Java-Practice\\Spring-Boot-REST-API-with-MySQL\\src\\main\\resources\\static\\documents";
	
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
