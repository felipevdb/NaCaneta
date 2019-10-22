package nacaneta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	ModelAndView modelView = new ModelAndView("welcome");
	List<ListaMaterial> listaMaterial;
	List<Loja> loja;
	List<Escola> escola;
	List<Cotacao> cotacao;

	@RequestMapping("/welcome")
	public ModelAndView Index() {

		listaMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		loja = new LojaDao(WebMvcConfig.getDataSource()).getAll();
		escola = new EscolaDao(WebMvcConfig.getDataSource()).getAll();

		modelView.addObject("listaMaterial", listaMaterial);
		modelView.addObject("loja", loja);
		modelView.addObject("escola", escola);

		return modelView;
	}

	@ResponseBody
	@RequestMapping(value = "/listCotacao", method = RequestMethod.GET)
	public String listCotacao(HttpServletRequest request, Model model) {
		cotacao = new CotacaoDao(WebMvcConfig.getDataSource()).getAll();
		List<String> cotacoes_id = new ArrayList<String>();

		cotacoes_id.add(String.valueOf(cotacao.get(0).getId()));

		return String.join(",", cotacoes_id);
	}

}