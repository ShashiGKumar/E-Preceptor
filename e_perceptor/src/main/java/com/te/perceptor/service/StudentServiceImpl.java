package com.te.perceptor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.perceptor.dao.StudentCredential;
import com.te.perceptor.dao.StudentRepository;
import com.te.perceptor.model.StudentAttributes;
import com.te.perceptor.model.StudentLoginCredentials;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentCredential studentCredentials;

	@Override
	public StudentAttributes add(StudentAttributes studentAttributes) {
		if (studentAttributes != null) {
			StudentAttributes saveStudentDetails = studentRepository.save(studentAttributes);
			return saveStudentDetails;
		}
		throw new RuntimeException("Please enter the datails");
	}

	@Override
	public StudentAttributes update(StudentAttributes studentAttributes, String sname) {
		if (sname != null) {
			StudentAttributes updated = studentRepository.save(studentAttributes);
			return updated;
		}
		throw new RuntimeException("Nothing has been updated");
	}

	@Override
	public StudentAttributes fetch(StudentAttributes studentAttributes, Integer sid) {
		if (sid > 0) {
			StudentAttributes findById = studentRepository.findStudentAttributesBySid(sid);
			return findById;
		}
		throw new RuntimeException("Their is an error in fetching");
	}

	@Override
	public StudentAttributes delete(Integer sid, StudentAttributes studentAttributes) {
		if (sid > 0) {
			studentRepository.deleteById(sid);
		}
		return null;
	}

	@Override
	public boolean validate(StudentLoginCredentials studentLoginCredentials) {
		String username = studentLoginCredentials.getUsername();
		String password = studentLoginCredentials.getPassword();
		StudentLoginCredentials username2 = studentCredentials.findStudentLoginCredentialsByUsername(username);
		if (studentLoginCredentials.equals(username2)) {
			return true;
		}
		return false;
	}

}
