package springboot.nacaneta.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import springboot.nacaneta.config.WebMvcConfig;
import springboot.nacaneta.dao.CotacaoDao;
import springboot.nacaneta.dao.EscolaDao;
import springboot.nacaneta.dao.ListaMaterialDao;
import springboot.nacaneta.dao.LojaDao;
import springboot.nacaneta.model.Cotacao;
import springboot.nacaneta.model.Escola;
import springboot.nacaneta.model.ListaMaterial;
import springboot.nacaneta.model.Loja;

@RestController
public class Controller {
	List<ListaMaterial> listasMaterial;
	List<Loja> lojas;
	List<Escola> escolas;
	List<Cotacao> cotacoes;

	@GetMapping("/cotacao")
	public Model greeting(Model model) {
		return model;
	}

	@RequestMapping(value = "/listCotacoes", method = RequestMethod.GET)
	public String listCotacoes(HttpServletRequest request, Model model) {
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

		return json_cotacoes.toString();
	}

	@RequestMapping(value = "/listEscolas", method = RequestMethod.GET)
	public String listEscolas(HttpServletRequest request, Model model) {
		escolas = new EscolaDao(WebMvcConfig.getDataSource()).getAll();
		JsonArray json_escolas = new JsonArray();

		for (Escola escola : escolas) {
			JsonObject json_escola = new JsonObject();
			json_escola.addProperty("nome", escola.getNome());
			json_escola.addProperty("id", escola.getId());
			json_escolas.add(json_escola);
		}

		return json_escolas.toString();
	}

	@RequestMapping(value = "/listListasMaterial", method = RequestMethod.GET)
	public String listListasMaterial(HttpServletRequest request, Model model) {
		listasMaterial = new ListaMaterialDao(WebMvcConfig.getDataSource()).getAll();
		JsonArray json_listas = new JsonArray();

		for (ListaMaterial lista : listasMaterial) {
			JsonObject json_lista = new JsonObject();
			json_lista.addProperty("id", lista.getId());
			json_lista.addProperty("nome", String.valueOf(lista.getAno()) + "/" + String.valueOf(lista.getSerie()));
			json_listas.add(json_lista);
		}

		return json_listas.toString();
	}

	@RequestMapping(value = "/listListasMaterialbyEscola", method = RequestMethod.GET)
	public String listListasMaterialEscola(HttpServletRequest request, Model model) {
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

		return json_listas.toString();
	}

	@RequestMapping(value = "/listLojas", method = RequestMethod.GET)
	public String listLojas(HttpServletRequest request, Model model) {
		lojas = new LojaDao(WebMvcConfig.getDataSource()).getAll();
		JsonArray json_lojas = new JsonArray();

		for (Loja loja : lojas) {
			JsonObject json_loja = new JsonObject();
			json_loja.addProperty("id", loja.getId());
			json_loja.addProperty("nome", loja.getNome());
			json_lojas.add(json_loja);
		}

		return json_lojas.toString();
	}

	@PostMapping("/cotacao")
	public Model registerCotacao(HttpServletRequest request, Model model) {

		boolean result = addCotacao(request.getParameter("valor"), request.getParameter("lista"),
				request.getParameter("loja"));

		return model;
	}

	static boolean addCotacao(String valor, String lista, String loja) {
		if (valor.matches("^[0-9][0-9,.]+") && lista != "-" && loja != "-" && lista.isEmpty() == false
				&& loja.isEmpty() == false) {

			String[] parameters = { valor.replace(',', '.'), lista, loja };

			try {
				new CotacaoDao(WebMvcConfig.getDataSource()).insert(parameters);
			} catch (SQLException e) {
				System.out.println(e);
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

}