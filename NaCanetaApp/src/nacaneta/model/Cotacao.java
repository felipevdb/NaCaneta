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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public float getValor() {
		return this.valor;
	}
	
	public ListaMaterial getLista_material() {
		return this.lista_material;
	}
	
	public Loja getLoja() {
		return this.loja;
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
