package springboot.nacaneta.model;

public class Produto {
	
	public int id;
	public String descricao;
	public String marca;
	public float preco;
	
	public Produto(String descricao, String marca, float preco) {
		this.descricao = descricao;
		this.marca = marca;
		this.preco = preco;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public float getpreco() {
		return this.preco;
	}
}
