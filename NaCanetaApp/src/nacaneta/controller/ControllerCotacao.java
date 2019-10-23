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
	List<ListaMaterial> listasMaterial;
	List<Loja> lojas;
	List<Escola> escolas;
	List<Cotacao> cotacoes;

	@RequestMapping("/welcome")
	public ModelAndView Index() {
		ModelAndView modelView = new ModelAndView("welcome");

		/*
		 * listasMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		 * lojas = new LojaDao(WebMvcConfig.getDataSource()).getAll(); escolas = new
		 * EscolaDao(WebMvcConfig.getDataSource()).getAll();
		 * 
		 * modelView.addObject("listaMaterial", listasMaterial);
		 * modelView.addObject("loja", lojas); modelView.addObject("escola", escolas);
		 */

		return modelView;
	}

	@ResponseBody
	@RequestMapping(value = "/listCotacoes", method = RequestMethod.GET)
	public String listCotacoes(HttpServletRequest request, Model model) {
		cotacoes = new CotacaoDao(WebMvcConfig.getDataSource()).getAll();
		List<String> cotacoes_values = new ArrayList<String>();

		for (Cotacao cotacao : cotacoes) {
			cotacoes_values.add(String.valueOf(cotacao.getValor()));
		}

		return String.join(",", cotacoes_values);
	}

	@ResponseBody
	@RequestMapping(value = "/listEscolas", method = RequestMethod.GET)
	public String listEscolas(HttpServletRequest request, Model model) {
		escolas = new EscolaDao(WebMvcConfig.getDataSource()).getAll();
		List<String> escolas_nomes = new ArrayList<String>();

		for (Escola escola : escolas) {
			escolas_nomes.add(String.valueOf(escola.getNome()));
		}

		return String.join(",", escolas_nomes);
	}

	@ResponseBody
	@RequestMapping(value = "/listListasMaterial", method = RequestMethod.GET)
	public String listListasMaterial(HttpServletRequest request, Model model) {
		listasMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		List<String> listas_nomes = new ArrayList<String>();

		for (ListaMaterial lista : listasMaterial) {
			listas_nomes.add(String.valueOf(lista.getAno()) + "/" + String.valueOf(lista.getSerie()));
		}

		return String.join(",", listas_nomes);
	}
	
	@ResponseBody
	@RequestMapping(value = "/listLojas", method = RequestMethod.GET)
	public String listLojas(HttpServletRequest request, Model model) {
		lojas = new LojaDao(WebMvcConfig.getDataSource()).getAll();
		List<String> lojas_nomes = new ArrayList<String>();

		for (Loja loja : lojas) {
			lojas_nomes.add(String.valueOf(loja.getNome()));
		}

		return String.join(",", lojas_nomes);
	}

}