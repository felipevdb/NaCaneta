import java.util.ArrayList;

public class ControllerCotacao {
	ArrayList<Cotacao> cotacoes = new ArrayList<Cotacao>();
	ArrayList<Escola> escolas = new ArrayList<Escola>();
	ArrayList<Loja> lojas = new ArrayList<Loja>();
	String resultado = "";

	//////////////// Registrar////////////////
	public void registrarCotacao(ListaMaterial lista_material, Loja loja) {
		cotacoes.add(new Cotacao(lista_material, loja));
	}

	public void registrarEscola(String nome, String endereco, String telefone) {
		escolas.add(new Escola(nome, endereco, telefone));
	}

	public void registrarLoja(String nome, String endereco, String telefone) {
		lojas.add(new Loja(nome, endereco, telefone));
	}

	public void registrarListaMaterial(Escola escola, String serie, int ano) {
		escola.adicionarListaMaterial(serie, ano);
	}

	public void registrarProduto(Loja loja, String descricao, String marca, float preco) {
		loja.adicionarProduto(descricao, marca, preco);
	}

	public void registrarItem(Escola escola, String serie, int ano) {
		escola.listasmateriais.add(new ListaMaterial(serie, ano));
	}

	//////////////// Listar////////////////
	public String mostrarCotacoes() {
		cotacoes.forEach(l -> {
			resultado = resultado + l.valor + "; ";
		});
		return resultado;
	}

	public String mostrarEscolas() {
		escolas.forEach(e -> {
			resultado = resultado + e.nome + "; ";
		});
		return resultado;
	}

	public String mostrarLojas() {
		lojas.forEach(lj -> {
			resultado = resultado + lj.nome + "; ";
		});
		return resultado;
	}

	public String mostrarListasMateriais() {
		escolas.forEach(e -> {
			e.listasmateriais.forEach(lm -> {
				resultado = resultado + lm.ano + "; ";
			});
		});
		return resultado;
	}

	public String mostrarProdutos() {
		lojas.forEach(l -> {
			l.mostrarProdutos().forEach(p -> {
				resultado = resultado + p.descricao + "; ";
			});
		});
		return resultado;
	}

	public String mostrarItens() {
		escolas.forEach(e -> {
			e.listasmateriais.forEach(lm -> {
				lm.itens.forEach(i -> {
					resultado = resultado + i.descricao + "; ";
				});
			});
		});
		return resultado;
	}

	//////////////// Editar////////////////
	public void editarCotacao() {

	}

	public void editarEscola() {

	}

	public void editarLoja() {

	}

	public void editarListaMaterial() {

	}

	public void editarProduto() {

	}

	public void editarItem() {

	}

	//////////////// Excluir////////////////
	public void excluirCotacao() {

	}

	public void excluirEscola() {

	}

	public void excluirLoja() {

	}

	public void excluirListaMaterial() {

	}

	public void excluirProduto() {

	}

	public void excluirItem() {

	}
}
