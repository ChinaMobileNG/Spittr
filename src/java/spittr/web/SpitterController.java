package spittr.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping(value="/spitter")
public class SpitterController {
	private SpitterRepository spitterRepsitory;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		// TODO Auto-generated constructor stub
		this.spitterRepsitory=spitterRepository;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistrationForm(Model model){
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	/**
	 * Deal the post request from registration form
	 * @param spitter  spitter will be initialized with the homonymous parameters
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(
			@Valid Spitter spitter,
			Errors errors){
		if(errors.hasErrors()){
			return "registerForm";
		}
		spitterRepsitory.addSpitter(spitter);
		return "redirect:/spitter/"+spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showProfile(@PathVariable String username,Model model){
		Spitter spitter = spitterRepsitory.findSpitterById(username);
		model.addAttribute("spitter", spitter);
		return "profile";
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public String signin(){
		return "signInForm";
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String processSignIn(HttpServletRequest request){
		String username=request.getParameter("username");
		return "redirect:/spitter/"+username;
	}
}
