package nacaneta.model;


public class Cotacao {
	
	private int id;
	public float valor;
	public Escola escola;
	public ListaMaterial lista_material;
	public Loja loja;

	public Cotacao(Escola escola, ListaMaterial lista_material, Loja loja, float valor) {
		this.escola = escola;
		this.lista_material = lista_material;
		this.loja = loja;
		this.valor = valor;
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
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Escola getEscola() {
		return this.escola;
	}
	
	public ListaMaterial getLista_material() {
		return this.lista_material;
	}
	
	public Loja getLoja() {
		return this.loja;
	}


}
