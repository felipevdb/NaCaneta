import java.util.ArrayList;

public class ListaMaterial {
	public String serie;
	public int ano;
	public ArrayList<Item> itens;

	public ListaMaterial(String serie, int ano) {
		this.serie = serie;
		this.ano = ano;
		this.itens = new ArrayList<Item>();
	}
}
