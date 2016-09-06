package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository){
		this.spittleRepository=spittleRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model){
		//spittleRepository.createSpittles(100, 20);
		model.addAttribute("spittleList", spittleRepository.findAllSpittles());
		return "spittles";
	}
	
	@RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
	public String findSpittleById(@PathVariable Long spittleId,Model model){
		model.addAttribute(spittleRepository.findSpittleById(spittleId));
		return "spittle";
	}

}
