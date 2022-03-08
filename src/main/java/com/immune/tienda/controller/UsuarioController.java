package com.immune.tienda.controller;

import com.immune.tienda.entity.Usuario;
import com.immune.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService userService;

	@GetMapping("/usuarios")
	public ResponseEntity<Object> getUsers() {
		return new ResponseEntity<Object>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/usuarioPorCorreo")
	public ResponseEntity<Object> getUserByEmail(@RequestParam String correo) {
		return new ResponseEntity<Object>(userService.getUserByEmail(correo), HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<Object> registerUser(@RequestBody Usuario user) throws Exception {
		try {			
			return new ResponseEntity<Object>(userService.registerUser(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}	

	@RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}