package nacaneta.model;

public class Cotacao {
	
	private int id;
	public float valor;
	public ListaMaterial lista_material;
	public Loja loja;

	public Cotacao(ListaMaterial lista_material, Loja loja) {
		this.lista_material = lista_material;
		this.loja = loja;
		this.valor = calcularValor(this.lista_material, this.loja);
	}

	public float mostrarValor() {
		return this.valor;
	}

	public boolean trocarLoja(Loja loja) {
		this.loja = loja;
		return true;
	}

	public boolean trocarListaMaterial(ListaMaterial lista_material) {
		this.lista_material = lista_material;
		return true;
	}

	private float calcularValor(ListaMaterial lista_material, Loja loja) {
		if (validarProdutos(lista_material, loja)) {
			return 100;
		} else {
			return -1;
		}
	}

	private boolean validarProdutos(ListaMaterial lista_material, Loja loja) {
		return true;
	}
}
