package nacaneta.model;


public class Cotacao {
	
	private int id;
	public float valor;
	public ListaMaterial lista_material;
	public Loja loja;


	public Cotacao(ListaMaterial lista_material, Loja loja, float valor) {
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
	
	public ListaMaterial getLista_material() {
		return this.lista_material;
	}
	
	public Loja getLoja() {
		return this.loja;
	}


}
