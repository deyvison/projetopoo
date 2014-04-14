package poo.maven.projetopoo;

public class ItemDeVenda {
	
	Produto produto;
	int quantidade;
	
	public ItemDeVenda(Produto p, int quant){
		produto = p;
		this.quantidade = quant;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

}
