package nacaneta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class ControllerCotacao {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		String message = "Teste cotacao";
		return new ModelAndView("welcome", "message", message);
	}
}