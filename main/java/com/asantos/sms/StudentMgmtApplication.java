package com.asantos.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asantos.sms.entity.Student;
import com.asantos.sms.repository.StudentRepository;

@SuppressWarnings("unused")
@SpringBootApplication
public class StudentMgmtApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApplication.class, args);
	}

	
	@SuppressWarnings("unused")
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * first input on database
		 * 
		 * Student st1 = new Student("Bruce", "Wayne", "batman@email.com");
		 * studentRepository.save(st1); 
		 * 
		 * Student st2 = new Student("Christopher", "Smith", "peacemaker@email.com"); 
		 * studentRepository.save(st2); 
		 * 
		 * Student st3 = new Student("Adrian", "Chase", 
		 * "vigilante@email.com"); studentRepository.save(st3);
		 */
		
	}

}
