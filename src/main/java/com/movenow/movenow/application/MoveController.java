package com.movenow.movenow.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MoveController {
	
	
	@GetMapping("api/moves")
	@ResponseBody
	  public String sayHello() {
		
		
		
		return "Hellooooo World";
	  }

}
