package poo.maven.projetopoo.gerentes;

import poo.maven.projetopoo.Produto;
import poo.maven.projetopoo.Venda;
import poo.maven.projetopoo.excecoes.QuantidadeInvalidaException;

public class GerenteDeVendas {
	
	GerenteDeProdutos gerenteProduto;
	
	public GerenteDeVendas(GerenteDeProdutos gerente){
		this.gerenteProduto = gerente;
	}
	
	public void venderProduto(long codProduto, int quant) {
		Produto p = this.gerenteProduto.getProduto(codProduto);
		if(quant > p.getQuantidade() || quant <= 0){
			throw new QuantidadeInvalidaException("Quantidade Inv�lida");
//		}
//		else if(p.){
//			
		}
		p.setQuantidade(p.getQuantidade()-quant);
	}

	public void vender(Venda v) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
