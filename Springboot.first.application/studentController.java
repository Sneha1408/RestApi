package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {
	
	@GetMapping("/Student")
	public Student getStudent()
	{
		return new Student("sneha","rishi");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> students = new ArrayList<>();
		students.add(new Student("sneha","yadav"));
		students.add(new Student("chetan","kumar"));
		students.add(new Student("ram","yadav"));
		students.add(new Student("sneha","upre"));
		return students;
	}
	
	
	// build rest API to handle query parameters
		//http://localhost:8080/student/query?firstName=sneha&lastName=yadav
	@GetMapping("/student/query")
		public Student studentQueryParam(@RequestParam(name="firstName")String firstName,@RequestParam(name="lastName")String lastName)
		{
			return new Student(firstName,lastName);
		}

}