package springboot.nacaneta.model;

import java.util.ArrayList;

public class Escola {
	
	public int id;
	public String nome;
	public String endereco;
	public String telefone;
	public ArrayList<ListaMaterial> listasmateriais;

	public Escola() {
		this.listasmateriais = new ArrayList<ListaMaterial>();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEndereco (String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setTelefone (String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public ArrayList<ListaMaterial> getListasmateriais(){
		return this.listasmateriais;
	}

	public boolean adicionarListaMaterial(ListaMaterial listaMaterial) {
		this.listasmateriais.add(listaMaterial);
		return true;
	}

	public boolean excluirListaMaterial(int numero_lista) {
		if (listasmateriais.size() >= numero_lista) {
			this.listasmateriais.remove(numero_lista);
			return true;
		} else {
			return false;
		}
	}

	public boolean editarListaMaterial(int numero_lista, String serie, int ano) {
		if (listasmateriais.size() >= numero_lista) {
			this.listasmateriais.get(numero_lista).serie = serie;
			this.listasmateriais.get(numero_lista).ano = ano;
			return true;
		} else {
			return false;
		}
	}

	public boolean adicionarItem(ListaMaterial lista_material, String descricao, int quantidade) {
		lista_material.itens.add(new Item(descricao, quantidade));
		return true;
	}

	public boolean excluirItem(ListaMaterial lista_material, int numero_item) {
		if (lista_material.itens.size() >= numero_item) {
			lista_material.itens.remove(numero_item);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Item> mostrarItens(ListaMaterial lista_material) {
		return lista_material.itens;
	}

	public boolean editarItens(ListaMaterial lista_material, int numero_item, String descricao, int quantidade) {
		if (lista_material.itens.size() >= numero_item) {
			lista_material.itens.get(numero_item).descricao = descricao;
			lista_material.itens.get(numero_item).quantidade = quantidade;
			return true;
		} else {
			return false;
		}
	}

}
