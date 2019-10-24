package nacaneta.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

		return modelView;
	}

	@ResponseBody
	@RequestMapping(value = "/listCotacoes", method = RequestMethod.GET)
	public JsonArray listCotacoes(HttpServletRequest request, Model model) {
		cotacoes = new CotacaoDao(WebMvcConfig.getDataSource()).getAll();
		JsonArray json_cotacoes = new JsonArray();

		for (Cotacao cotacao : cotacoes) {
			JsonObject json_cotacao = new JsonObject();
			json_cotacao.addProperty("valor", String.valueOf(cotacao.getValor()));
			json_cotacao.addProperty("lista", String
					.valueOf(cotacao.getLista_material().getAno() + "/" + cotacao.getLista_material().getSerie()));
			json_cotacao.addProperty("loja", String.valueOf(cotacao.getLoja().getNome()));
			json_cotacao.addProperty("escola", String.valueOf(cotacao.getEscola().getNome()));
			json_cotacoes.add(json_cotacao);
		}

		return json_cotacoes;
	}

	@ResponseBody
	@RequestMapping(value = "/listEscolas", method = RequestMethod.GET)
	public JsonArray listEscolas(HttpServletRequest request, Model model) {
		escolas = new EscolaDao(WebMvcConfig.getDataSource()).getAll();
		JsonArray json_escolas = new JsonArray();

		for (Escola escola : escolas) {
			JsonObject json_escola = new JsonObject();
			json_escola.addProperty("nome", escola.getNome());
			json_escola.addProperty("id", escola.getId());
			json_escolas.add(json_escola);
		}

		return json_escolas;
	}

	@ResponseBody
	@RequestMapping(value = "/listListasMaterial", method = RequestMethod.GET)
	public JsonArray listListasMaterial(HttpServletRequest request, Model model) {
		listasMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		JsonArray json_listas = new JsonArray();

		for (ListaMaterial lista : listasMaterial) {
			JsonObject json_lista = new JsonObject();
			json_lista.addProperty("id", lista.getId());
			json_lista.addProperty("nome", String.valueOf(lista.getAno()) + "/" + String.valueOf(lista.getSerie()));
			json_listas.add(json_lista);
		}

		return json_listas;
	}

	@ResponseBody
	@RequestMapping(value = "/listListasMaterialbyEscola", method = RequestMethod.GET)
	public JsonArray listListasMaterialEscola(HttpServletRequest request, Model model) {
		JsonArray json_listas = new JsonArray();
		try {
			listasMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource())
					.getByEscola(request.getParameter("escola"));

			for (ListaMaterial lista : listasMaterial) {
				JsonObject json_lista = new JsonObject();
				json_lista.addProperty("id", lista.getId());
				json_lista.addProperty("nome", String.valueOf(lista.getAno()) + "/" + String.valueOf(lista.getSerie()));
				json_listas.add(json_lista);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return json_listas;
	}

	@ResponseBody
	@RequestMapping(value = "/listLojas", method = RequestMethod.GET)
	public JsonArray listLojas(HttpServletRequest request, Model model) {
		lojas = new LojaDao(WebMvcConfig.getDataSource()).getAll();
		JsonArray json_lojas = new JsonArray();

		for (Loja loja : lojas) {
			JsonObject json_loja = new JsonObject();
			json_loja.addProperty("id", loja.getId());
			json_loja.addProperty("nome", loja.getNome());
			json_lojas.add(json_loja);
		}

		return json_lojas;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public void registerCotacao(HttpServletRequest request, Model model) {
		String[] parameters = { request.getParameter("valor"), request.getParameter("lista"),
				request.getParameter("loja") };

		try {
			new CotacaoDao(WebMvcConfig.getDataSource()).insert(parameters);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}