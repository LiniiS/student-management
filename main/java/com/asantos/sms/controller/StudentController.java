package com.asantos.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asantos.sms.entity.Student;
import com.asantos.sms.service.StudentService;

@Controller
public class StudentController {

	// injection first
	//service class helps on the interaction
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// handler method to deal with the list and return mode & view
	@GetMapping("/students")
	private String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students"; // view name
	}

	//get the view form to add new Student
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// student object to receive the data from form
		Student student = new Student();
		model.addAttribute("student", student);

		return "create_student";
	}

	//calls the students page after saving
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);

		return "redirect:/students";

	}

	//brings the student on button target and fill the form page
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		//get student from db by its id -> not handling with the null/invalid ids 
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//updating student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		// return an form filled with data of this id
		return "edit_student";
	}


	// delete the target student via id
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id){
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
	
}
