package nacaneta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nacaneta.config.WebMvcConfig;
import nacaneta.dao.CotacaoDao;
import nacaneta.dao.EscolaDao;
import nacaneta.dao.ListaMaterialDao;
import nacaneta.dao.LojaDao;
import nacaneta.model.Cotacao;
import nacaneta.model.Escola;
import nacaneta.model.ListaMaterial;
import nacaneta.model.Loja;

@Controller
public class ControllerCotacao {

	List<ListaMaterial> listaMaterial;
	List<Loja> loja;
	List<Escola> escola;
	List<Cotacao> cotacao;

	@RequestMapping("/welcome")
	public ModelAndView Index() {

		listaMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		loja = new LojaDao(WebMvcConfig.getDataSource()).getAll();
		escola = new EscolaDao(WebMvcConfig.getDataSource()).getAll();
		cotacao = new CotacaoDao(WebMvcConfig.getDataSource()).getAll();

		ModelAndView modelView = new ModelAndView("welcome");

		modelView.addObject("listaMaterial", listaMaterial);
		modelView.addObject("loja", loja);
		modelView.addObject("escola", escola);
		modelView.addObject("cotacao", cotacao);

		return modelView;
	}

}