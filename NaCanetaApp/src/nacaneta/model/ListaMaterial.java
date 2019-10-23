package nacaneta.model;

import java.util.ArrayList;

public class ListaMaterial {
	
	public int id;
	public String serie;
	public int ano;
	public ArrayList<Item> itens;
	

	public ListaMaterial() {
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSerie() {
		return this.serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void setItens(ArrayList<Item> itens){
		this.itens = itens;
	}
	
	public ArrayList<Item> getItens(){
		return this.itens;
	}
}
