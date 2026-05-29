package com.example.demotest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {
	
	@GetMapping("sumar")
	public ResponseEntity<Integer> sumar(@RequestParam(name="op1") int op1, @RequestParam(name="op2") int op2) {
		return ResponseEntity.ok().body(op1 + op2);
	}
	
	
}
