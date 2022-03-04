package com.te.perceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.perceptor.model.StudentAttributes;
import com.te.perceptor.model.StudentLoginCredentials;
import com.te.perceptor.model.StudentResponse;
import com.te.perceptor.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/add")
	public ResponseEntity<StudentResponse> adding(@RequestBody StudentAttributes studentAttributes) {
		StudentAttributes add = studentService.add(studentAttributes);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setError(false);
		studentResponse.setData(add);
		return new ResponseEntity<>(studentResponse, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<StudentResponse> updating(@RequestBody StudentAttributes studentAttributes) {
		String sname = studentAttributes.getSname();
		StudentAttributes update = studentService.update(studentAttributes, sname);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setError(false);
		studentResponse.setData(update);
		return new ResponseEntity<>(studentResponse, HttpStatus.OK);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<StudentResponse> fetch(@RequestParam Integer sid, StudentAttributes studentAttributes){
		StudentAttributes fetch = studentService.fetch(studentAttributes, sid);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setError(false);
		studentResponse.setData(fetch);
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<StudentResponse> delete(@RequestParam Integer sid,StudentAttributes studentAttributes){
		StudentAttributes delete = studentService.delete(sid,studentAttributes);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setError(false);
		studentResponse.setData(delete);
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
	}
	
	@Validated
	public ResponseEntity<StudentResponse> validate(@RequestBody StudentLoginCredentials studentLoginCredentials){
		boolean validate = studentService.validate(studentLoginCredentials);
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setError(false);
		studentResponse.setData(validate);
		return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
	}

}
