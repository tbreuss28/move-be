package com.movenow.application;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MoveController {
	
	
	@GetMapping("api/moves")
	@ResponseBody
	  public ResponseEntity<String> sayHello() {
		
		
		
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	  }

}
