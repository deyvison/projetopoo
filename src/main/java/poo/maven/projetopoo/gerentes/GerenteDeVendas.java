package poo.maven.projetopoo.gerentes;

import java.util.List;
import java.util.LinkedList;

import poo.maven.projetopoo.ItemDeVenda;
import poo.maven.projetopoo.Produto;
import poo.maven.projetopoo.Venda;
import poo.maven.projetopoo.excecoes.ClienteInexistenteException;
import poo.maven.projetopoo.excecoes.QuantidadeInvalidaException;

public class GerenteDeVendas {

	private List <Venda> vendas;
	GerenteDeProdutos gerenteProduto;
	
	public GerenteDeVendas(GerenteDeProdutos gerente){
		this.gerenteProduto = gerente;
		vendas = new LinkedList<Venda>();
	}
	
	public void vender(Venda v) {
		List <ItemDeVenda> itens = v.getItens();;
		for (ItemDeVenda i: itens) {
			Produto p = i.getProduto();
			int quant = i.getQuantidade();
			p.setQuantidade(p.getQuantidade()-quant);
		}
	}
	
	public void adcionarItemDeVenda(long codVenda, long codProduto, int quantidade) {
		Produto p = this.gerenteProduto.getProduto(codProduto);
		if (quantidade <= 0 || quantidade > p.getQuantidade()) {
			throw new QuantidadeInvalidaException("Quantidade Inválida");
		}
		Venda v = this.getVenda(codVenda);
		ItemDeVenda i = new ItemDeVenda(p,quantidade);
		v.adicionarItem(i);
		

	}	
	
	public void adicionarVenda(Venda v){
		this.vendas.add(v);
	}
	
	public Venda getVenda(long codVenda) {
		for (Venda v: this.vendas) {
			if (v.getCod() == codVenda) {
				return v;
			}
		}
		return null;
	}
	
}
