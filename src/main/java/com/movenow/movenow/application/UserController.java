package com.movenow.movenow.application;

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
	  public String sayHello() {
		
		
		
		return "Hellooooo User";
	  }

}
