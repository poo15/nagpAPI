package com.nagarro.nagp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.model.User;
import com.nagarro.nagp.service.UserLogin;

@CrossOrigin("*")
@RequestMapping("/userLogin")
@RestController
public class LoginResource {
	
	@Autowired
	private UserLogin userLogin;
	
	@GetMapping("/all")
	public List<User> login() {
		
		return userLogin.getAllusers();
	}
	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
//	@GetMapping("/secured/all")
//	public String securedHello(Model model) {
//		return "register";
//	}
	
	@PostMapping("/")
	public ResponseEntity<?> login(@RequestBody User user){
		
		return ResponseEntity.ok().body(userLogin.login(user));
	}
	
	@PostMapping("/admin")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		int id = userLogin.addAdmin(user);
		return ResponseEntity.ok().body("User added"+id);
	}
	
	
}
