package poo.maven.projetopoo;

import java.util.List;
import java.util.LinkedList;

public class Venda {
	
	List <ItemDeVenda> itens;
	long cod;
	
	public Venda(long cod){
		itens = new LinkedList <ItemDeVenda> ();
		this.cod = cod;
	}
	
	public void adicionarItem(ItemDeVenda i) {
		itens.add(i);
	}

	public List<ItemDeVenda> getItens() {
		return itens;
	}

	public long getCod() {
		return cod;
	}

}
