package nacaneta.model;

public class Item {
	int id;
	public String descricao;
	public int quantidade;

	public Item(int id,String descricao, int quantidade) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.id = id;
	}

}
