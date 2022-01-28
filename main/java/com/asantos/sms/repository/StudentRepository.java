package com.asantos.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asantos.sms.entity.Student;


public interface StudentRepository extends JpaRepository <Student, Long>{

}
