package nacaneta.controller;

import java.io.Console;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nacaneta.config.WebMvcConfig;
import nacaneta.dao.ListaMaterialDao;
import nacaneta.model.*;
 
@Controller
public class ControllerCotacao {
	
	List<ListaMaterial> listaMaterial;
 
	@RequestMapping("/welcome")
	public ModelAndView Index() {
		
		listaMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		
		ModelAndView modelView = new ModelAndView("welcome");
		
		modelView.addObject("listaMaterial", listaMaterial);
		
		return modelView;
	}
}