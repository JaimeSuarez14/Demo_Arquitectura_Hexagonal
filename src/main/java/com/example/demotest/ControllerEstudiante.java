package com.example.demotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiante")
public class ControllerEstudiante {

	@Autowired
	private RepositoryEstudiante repo;
	
	
	@PostMapping("/registrar")
	public Estudiante registrarEstudiante(@RequestBody Estudiante nuevo) {
		Estudiante e = repo.save(nuevo);
		return e;
	}
	
	@GetMapping("/{id}")
	public Estudiante consultarEstudiante(@PathVariable(name = "id") int id) {
		Estudiante e = repo.findById(id).get();
		return e;
	}
}