package nacaneta.model;

import java.util.ArrayList;

public class Loja {
	public int id;
	public String nome;
	public String endereco;
	public String telefone;
	public ArrayList<Produto> produtos;

	public Loja() {
		this.produtos = new ArrayList<Produto>();
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
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos= produtos;
	}
	
	public ArrayList<Produto> getProdutos() {
		return this.produtos;
	}

	public boolean adicionarProduto(int id, String descricao, String marca, float preco) {
		this.produtos.add(new Produto(descricao, marca, preco));
		return true;
	}

	public boolean excluirProduto(int numero_produto) {
		if (produtos.size() >= numero_produto) {
			this.produtos.remove(numero_produto);
			return true;
		} else {
			return false;
		}
	}

	public boolean editarProduto(int numero_produto, String descricao, String marca, float preco) {
		if (produtos.size() >= numero_produto) {
			this.produtos.get(numero_produto).descricao = descricao;
			this.produtos.get(numero_produto).marca = marca;
			this.produtos.get(numero_produto).preco = preco;
			return true;
		} else {
			return false;
		}
	}
}
