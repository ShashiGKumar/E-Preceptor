package com.te.perceptor.service;

import com.te.perceptor.model.StudentAttributes;
import com.te.perceptor.model.StudentLoginCredentials;

public interface StudentService {

	StudentAttributes add(StudentAttributes studentAttributes);

	StudentAttributes update(StudentAttributes studentAttributes, String sname);

	StudentAttributes fetch(StudentAttributes studentAttributes, Integer sid);

	StudentAttributes delete(Integer sid, StudentAttributes studentAttributes);

	boolean validate(StudentLoginCredentials studentLoginCredentials);

}
