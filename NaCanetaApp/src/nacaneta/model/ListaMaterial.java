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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getSerie() {
		return this.serie;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public ArrayList<Item> getItens(){
		return this.itens;
	}
}
