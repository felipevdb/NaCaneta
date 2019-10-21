package nacaneta.model;

public class Item {
	int id;
	public String descricao;
	public int quantidade;

	public Item(String descricao, int quantidade) {
		this.descricao = descricao;
		this.quantidade = quantidade;
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
	
	public int getQuantidade() {
		return this.quantidade;
	}
}
