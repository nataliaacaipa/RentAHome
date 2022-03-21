package com.immune.rentahouse.controller;

import java.util.ArrayList;

import com.immune.rentahouse.entity.Housing;
import com.immune.rentahouse.entity.Lessee;
import com.immune.rentahouse.entity.Security;
import com.immune.rentahouse.entity.User;
import com.immune.rentahouse.service.HousingService;
import com.immune.rentahouse.service.LesseeService;
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

	@Autowired
	private LesseeService lesseeService;
    
    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView model = new ModelAndView("login");
        return model;
    }

	@GetMapping("/index")
    public ModelAndView add() {

		User user = userService.getUserByMail("usuario@gmail.com");
		System.out.println(user.getId());

        ModelAndView model = new ModelAndView("index");
		model.addObject("user", user);

		model.addObject("b", true);
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
			
			System.out.println(user.getId());

			//Definimos el modelo.
			ModelAndView model = new ModelAndView("hello");
			Iterable<Housing> houses = (Iterable<Housing>) housingService.getHouses();
			Iterable<Lessee> lessees = (Iterable<Lessee>) lesseeService.getLessees();


			model.addObject("userID", user.getId());
			model.addObject("houses", houses);	
			model.addObject("lessees", lessees);
			model.addObject("ok", true);
			model.addObject("okay", true);

			model.addObject("b", true);
			model.addObject("username", username);
			model.addObject("user", user);
			model.addObject("lesseeService", lesseeService);
			model.addObject("housingService", housingService);


			return model;	
		}
		//Si no es correcta comunicamos el error y dejamos al usuario intentarlo de nuevo.
		else{
			//Lanzamos pantalla de log in.
			ModelAndView model = new ModelAndView("login");
			model.addObject("b", false);
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

	@PostMapping("/houseform")
	public ModelAndView houseform(){
		
		ModelAndView model = new ModelAndView("index");
		User user = userService.getUserByMail("usuario@gmail.com");

		model.addObject("user", user);
		model.addObject("b", true);

		return model;
	
		
	}

	@PostMapping("/housing")
    public ModelAndView newHouse(@RequestParam String phonenum, @RequestParam String location, @RequestParam String photo, @RequestParam String password) { 	

		password = Security.encryptPassword(password); //la que pone el usuario

		User user = userService.getUserByPass(password);

		ModelAndView model = new ModelAndView("index");

		model.addObject("b", false);
	

		try {

			Lessee lessee = new Lessee();

			lessee.setName(user.getName());
			lessee.setLastname(user.getLastname());
			lessee.setMail(user.getMail());
			lessee.setPassword(password);
			lessee.setPhonenum(phonenum);
			lessee.setId_user(user.getId());

			Lessee newLessee = lesseeService.saveLessee(lessee);

			Housing housing = new Housing();
			housing.setLocation(location);
			housing.setPhoto(photo);
			housing.setId_lessee(newLessee.getId());

			Housing newHousing = housingService.saveHousing(housing);

			model.addObject("newLessee", newLessee);
			model.addObject("newHousing", newHousing);
			model.addObject("okay", true);

			return model;

			
		} catch(Exception e) {
			model.addObject("okay", false);
			return model;
		}

	
	

    }

	
	@GetMapping("/house")
    public ModelAndView house() {
		
		ModelAndView model = new ModelAndView("hello");
		model.addObject("okay", true);

        return model;
    }




}


