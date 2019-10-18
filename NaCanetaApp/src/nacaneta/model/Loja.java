package nacaneta.model;

import java.util.ArrayList;

public class Loja {
	public int id;
	public String nome;
	public String endereco;
	public String telefone;
	public ArrayList<Produto> produtos;

	public Loja(int id, String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.produtos = new ArrayList<Produto>();
		this.id = id;
	}

	public boolean adicionarProduto(int id, String descricao, String marca, float preco) {
		this.produtos.add(new Produto(id, descricao, marca, preco));
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

	public ArrayList<Produto> mostrarProdutos() {
		return this.produtos;
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
