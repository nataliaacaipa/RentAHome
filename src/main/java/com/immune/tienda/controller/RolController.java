package com.immune.tienda.controller;

import com.immune.tienda.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolController {

	@Autowired
	private RolService rolService;

	@GetMapping("/roles")
	public ResponseEntity<Object> getRoles() {
		return new ResponseEntity<Object>(rolService.getRoles(), HttpStatus.OK);
	}

	@GetMapping("/rol")
	public ResponseEntity<Object> getUser(@RequestParam Integer rolId) {
		return new ResponseEntity<Object>(rolService.getRolById(rolId), HttpStatus.OK);
	}
}