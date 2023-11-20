package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student,Model model) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{StudentId}")
	public String editStudentForm(@PathVariable Long StudentId, Model model) {
		model.addAttribute("student", studentService.getStudentById(StudentId));
		return "edit_student";
	}

	@PostMapping("/students/{StudentId}")
	public String updateStudent(@PathVariable Long StudentId,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(StudentId);
//		existingStudent.setStudentId(StudentId);
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setStudentDept(student.getStudentDept());
		existingStudent.setStudentEmail(student.getStudentEmail());
		existingStudent.setStudentNumber(student.getStudentNumber());
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/{StudentId}")
	public String deleteStudent(@PathVariable Long StudentId) {
		studentService.deleteStudentById(StudentId);
		return "redirect:/students";
	}
	
}
