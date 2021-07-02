package com.movenow.movenow.application;

import com.movenow.movenow.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class UserController {
	
	@GetMapping("/")
    public String homePage() {
        return "home";
    }
	
	@GetMapping("/users")
	@ResponseBody
	  public ResponseEntity<User> sayHello() {
		var user = new User();
		
		user.setUserName("kirbby");
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	  }

}
