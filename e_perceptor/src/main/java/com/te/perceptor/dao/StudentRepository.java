package com.te.perceptor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.perceptor.model.StudentAttributes;
@Repository
public interface StudentRepository extends JpaRepository<StudentAttributes, Integer>{
	
	StudentAttributes findStudentAttributesBySid(Integer sid);
	
	StudentAttributes findstudentAttributesByUsername(String username);

}
