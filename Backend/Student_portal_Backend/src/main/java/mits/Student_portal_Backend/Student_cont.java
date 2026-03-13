package mits.Student_portal_Backend;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
@CrossOrigin(origins =" http://localhost:5173")
public class Student_cont {
	private final Student_Services ss;
	public Student_cont(Student_Services ser) {
		this.ss=ser;
	}
	//end urls 
	@PostMapping("/register")
	public String register(@RequestBody Student user) {
		ss.register(user);
		return "User Registered successfully";
	}
	@PostMapping("/login")
	public String login(@RequestBody Student user) {
		return ss.login(user.getEmail(), user.getPassword()) !=null? "login Successfull" : "invalid credentials";
	}
	
	//retrive
	
	@GetMapping("/users")
	public List<Student> getallusers() {
	    return ss.allusers();
	}
	//update
	
	@PutMapping("/update/{id}")
	public Student updatestu(@PathVariable Long id, @RequestBody Student st) {
	    return ss.updateStudent(id, st);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public String deletestud(@PathVariable Long id) {
		ss.deletestudent(id);
		return "deletion successfull";
	}
}
