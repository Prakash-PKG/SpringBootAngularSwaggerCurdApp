package com.app.pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pk.bean.Student;
import com.app.pk.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	private IStudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStduentData(
			@RequestBody Student student){
		  ResponseEntity<String> resp=null; 
		  try {  
			  Integer id=service.saveStudent(student);  
			  resp = new ResponseEntity<String>(
						"Product '"+id+"' created Successfully!",
						HttpStatus.OK
						);
			
          } catch (Exception e) {
			resp = new ResponseEntity<String>(
					"Unable to Save Product",
					HttpStatus.INTERNAL_SERVER_ERROR
					);
			e.printStackTrace();
		}
		return resp;
	}

}
