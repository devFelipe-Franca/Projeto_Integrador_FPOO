package Vending_Machine;

public class Produtos {
	
	private int codigo;
	private String produto;
	private double preco;
	private int quantidade;
	
	public Produtos(int codigo, String produto, double preco, int quantidade) {
		this.codigo     = codigo;
		this.produto    = produto;
		this.preco      = preco;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}