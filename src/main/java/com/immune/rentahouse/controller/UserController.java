package com.immune.rentahouse.controller;

import java.util.ArrayList;

import com.immune.rentahouse.entity.Housing;
import com.immune.rentahouse.entity.Security;
import com.immune.rentahouse.entity.User;
import com.immune.rentahouse.service.HousingService;
import com.immune.rentahouse.service.UserService;

import org.hibernate.exception.ConstraintViolationException;
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
	
	@Autowired
	private HousingService housingService;
    
    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView model = new ModelAndView("login");
        return model;
    }


	
	//En cuanto un usuario trata de identificarse.
    @PostMapping("/index")
	public ModelAndView login(@RequestParam String mail, @RequestParam String password) {
		
		//Recogemos la contraseña real del mail que nos ha dado el usuario en la base de datos.
		String truePassword = userService.getPassByMail(mail);
        
		//Aqui encriptamos la contraseña que ha puesto el usuario para poder compararla con la truePassword tambien encriptada.
		password = Security.encryptPassword(password);
		
		//Si la contraseña es correcta dejamos al usuario entrar a la pagina de inicio.
		if (password.equals(truePassword)){
			
			//pasamos el nombre entero del usuario
			String username = userService.getNamebyMail(mail);

			//recogemos el usuario 
			User user = userService.getUserByMail(mail);

			//Definimos el modelo.
			ModelAndView model = new ModelAndView("index");
			model.addObject("respuesta", false);
			model.addObject("username", username);
			model.addObject("user", user);

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
		
		try {
			ModelAndView modelL = new ModelAndView("login");
	
			String password = Security.encryptPassword(user.getPassword());
			user.setPassword(password);
			User newUser = userService.saveUser(user);
			modelL.addObject("newUser", newUser);
	
			Boolean okay = true;
			modelL.addObject("okay", okay);
			return modelL;
			
		} catch (Exception e) {
			Boolean okay = false;
			model.addObject("okay", okay);
			return model;
			//TODO: handle exception
		}

    }


	@GetMapping("/housing")
	public ModelAndView housing() {
	
		Boolean b = true;
		ModelAndView model = new ModelAndView("hello");
		model.addObject("b", b);
		return model;
	}

	@PostMapping("/housing")
    public ModelAndView newHouse(@RequestParam int id, @RequestParam String location, @RequestParam String photo) { //Nose si introducir por parametro el id_lessee


        ModelAndView model = new ModelAndView("hello");

		Housing housing = new Housing();
		//housing.setId_Lessee();

		housingService.save(housing);

		Boolean b = false;
		model.addObject("b", b);

		ArrayList<Housing> alHouses = (ArrayList<Housing>) housingService.getHouses();

		Boolean okay = true;
		model.addObject("okay", okay);
		return model;

    }

	//Cambio

	/*@PostMapping("/")
    public ModelAndView newLess(@RequestParam int phonenum) { //Nose si introducir por parametro el id_lessee
        ModelAndView model = new ModelAndView("hello");

		Boolean b = false;
		model.addObject("b", b);

		Boolean okay = true;
		model.addObject("okay", okay);
		return model;

    }*/


}


