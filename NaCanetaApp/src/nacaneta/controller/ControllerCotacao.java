package nacaneta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nacaneta.config.WebMvcConfig;
import nacaneta.dao.*;
import nacaneta.model.*;
 
@Controller
public class ControllerCotacao {
	
	List<ListaMaterial> listaMaterial;
	List<Loja> loja;
	List<Escola> escola;
 
	@RequestMapping("/welcome")
	public ModelAndView Index() {
		
		listaMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		loja = new LojaDao(WebMvcConfig.getDataSource()).getAll();
		escola = new EscolaDao(WebMvcConfig.getDataSource()).getAll();
		
		ModelAndView modelView = new ModelAndView("welcome");
		
		modelView.addObject("listaMaterial", listaMaterial);
		modelView.addObject("loja", loja);
		modelView.addObject("escola", escola);
		
		return modelView;
	}
	

	
}