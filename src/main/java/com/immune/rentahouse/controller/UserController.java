package com.immune.rentahouse.controller;

import com.immune.rentahouse.entity.Security;
import com.immune.rentahouse.entity.User;
import com.immune.rentahouse.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
	private UserService userService;
    
    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView model = new ModelAndView("login");
        return model;
    }

	
	//En cuanto un usuario trata de identificarse.
    @PostMapping("/login")
	public ModelAndView login(@RequestParam String mail, @RequestParam String password) {
		
		//Recogemos la contraseña real del mail que nos ha dado el usuario en la base de datos.
		String truePassword = userService.getPassByMail(mail);
        
		//Aqui encriptamos la contraseña que ha puesto el usuario para poder compararla con la truePassword tambien encriptada.
		password = Security.encryptPassword(password);
		
		//Si la contraseña es correcta dejamos al usuario entrar a la pagina de inicio.
		if (password.equals(truePassword)){
			//Definimos el modelo.
			ModelAndView model = new ModelAndView("index");
			model.addObject("respuesta", false);
			return model;	
		}
		//Si no es correcta comunicamos el error y dejamos al usuario intentarlo de nuevo.
		else{
			//Lanzamos pantalla de log in.
			ModelAndView model = new ModelAndView("login");
			model.addObject("respuesta", true);
			return model;	

	
		}	
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
	
		Boolean b = true;
		ModelAndView model = new ModelAndView("register");
		model.addObject("b", b);
		return model;
	}

	@PostMapping("/register")
    public ModelAndView create(User user) {
        ModelAndView model = new ModelAndView("register");

		Boolean b = false;
		model.addObject("b", b);

		String password = Security.encryptPassword(user.getPassword());
		user.setPassword(password);
		User newUser = userService.saveUser(user);
		model.addObject("newUser", newUser);

		Boolean okay = true;
		model.addObject("okay", okay);
		return model;

    }

	
	@GetMapping("/index")
    public ModelAndView index() {

        ModelAndView model = new ModelAndView("index");
        return model;
    }



}


