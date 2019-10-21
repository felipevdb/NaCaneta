package nacaneta.model;

import java.util.ArrayList;

public class ListaMaterial {
	
	public int id;
	public String serie;
	public int ano;
	public ArrayList<Item> itens;
	

	public ListaMaterial(String serie, int ano) {
		this.serie = serie;
		this.ano = ano;
		this.itens = new ArrayList<Item>();
	}
	
	public ListaMaterial(int id, String serie, int ano) {
		this.serie = serie;
		this.ano = ano;
		this.itens = new ArrayList<Item>();
		this.id = id;
	}
	
	public String getSerie() {
		return serie;
	}
}
