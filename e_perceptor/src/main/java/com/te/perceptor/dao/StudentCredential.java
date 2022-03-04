package com.te.perceptor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.perceptor.model.StudentLoginCredentials;

@Repository
public interface StudentCredential extends JpaRepository<StudentLoginCredentials, String>{
	
	StudentLoginCredentials findStudentLoginCredentialsByUsername(String Username);
	
//	@Query("select sname from StudentAttributes where sname=:''")

}
