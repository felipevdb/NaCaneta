package nacaneta.model;

public class Produto {
	
	public int Id;
	public String descricao;
	public String marca;
	public float preco;

	public Produto(int Id, String descricao, String marca, float preco) {
		this.descricao = descricao;
		this.marca = marca;
		this.preco = preco;
	}
}
