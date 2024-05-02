package com.foucsr.learnings.util;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.foucsr.learnings.mysql.database.model.User;
import com.foucsr.learnings.payload.ApiResponse;

public class PDFUtil {

	Logger logger = LoggerFactory.getLogger(PDFUtil.class);
	
	public ResponseEntity<?> getPDFContent() {
		
		String fileName = "Learnings";
		
		String extension = ".pdf";
		
		fileName = fileName + extension;
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		InputStreamResource file = null; 
		
		
		try {
			
			file = new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
			
		}
		catch(Exception e) {
			
			String msg = e.getLocalizedMessage();
			
			return new ResponseEntity(new ApiResponse(false, msg), HttpStatus.BAD_REQUEST);
			
		}
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName).contentType(MediaType.parseMediaType("application/vnd.pdf")).body(file);
		
	}
	
	private void insertDataIntoPDF(List<User> user) {
		
		for(User userObject : user) {
			
			
			
		}
		
	}
	
}
