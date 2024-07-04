package com.rest.spbtApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spbtApp.Repository.RtRepo;
import com.rest.spbtApp.entity.Student;

@RestController
public class Rest_Controller {

	@Autowired
	RtRepo repo;

	@GetMapping(path = "/students")
	public List<Student> getAllStudents() {
		List<Student> getallstudents = repo.findAll();
		return getallstudents;
	}

	@GetMapping(path = "student/{PatVarible_rollnum}")
	public Student getA_Student(@PathVariable int PatVarible_rollnum) {
		Student json = repo.findById(PatVarible_rollnum).get();
		return json;
	}

	@PostMapping(path = "student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addStudent(@RequestBody Student add) {
		repo.save(add);
	}

	@PutMapping(path = "student/update/{rollno}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updateStudent(@RequestBody Student upjs, @PathVariable int rollno) {
		Student update = repo.findById(rollno).get();
		update.setName(upjs.getName());
		update.setBranch(upjs.getBranch());
		update.setPercentage(upjs.getPercentage());
		repo.save(update);
	}

	@DeleteMapping(path = "student/delete/{rollno}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteStudent(@PathVariable int rollno) {
		Student delete = repo.findById(rollno).get();
		repo.delete(delete);
	}
}
