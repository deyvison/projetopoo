package poo.maven.projetopoo.gerentes;

import java.util.LinkedList;
import java.util.List;

import poo.maven.projetopoo.Cliente;
import poo.maven.projetopoo.excecoes.ClienteInexistenteException;
import poo.maven.projetopoo.excecoes.ClienteJaExistenteException;


public class GerenteDeClientes {

	private List <Cliente> clientes;
	
	public GerenteDeClientes(){
		clientes = new LinkedList<Cliente>();
	}

	public void cadastrarCliente(Cliente c) {
		if(isCadastrado(c.getId())){
			throw new ClienteJaExistenteException("Cliente j� cadastrado");
		}
		clientes.add(c);
		
	}
	
	public boolean isCadastrado(String Id){
		for(Cliente c: clientes){
			if(c.getId().equals(Id)){
				return true;
			}
		}
		return false;
	}

	public Cliente pesquisarCliente(String id) {
		for(Cliente c : this.clientes){
			if(c.getId().equals(id)){
				return c; 
			}
		}
		throw new ClienteInexistenteException("Cliente não cadastrado");
	}

	public List<Cliente> listClientes() {
		return this.clientes;
	}

	public void removerCliente(String id) {
		
		if(!this.isCadastrado(id)){
			throw new ClienteInexistenteException("Cliente inexistente");
		}
		this.clientes.remove(this.pesquisarCliente(id));
		
	}

	public void atualizarCliente(Cliente c1) {
		
		for(Cliente c : this.clientes){
			
			if(c.getId().equals(c1.getId())){
				c.setNome(c1.getNome());
				c.setId(c1.getId());
				break;
			}
		}
		
	}

	public Cliente getCliente(String id) {
		return this.pesquisarCliente(id);
		
	}
	
	

	public List<Cliente> pesquisarClientePeloNome(String nome) {
		List<Cliente> retorno = new LinkedList<Cliente>();
		
		for(Cliente c : this.clientes){
			if(c.getNome().equals(nome)){
				retorno.add(c);
			}
		}if(retorno.size()>0){
			return retorno;
		}else{
			throw new ClienteInexistenteException("Cliente Inexitente");
		}
		
		
		
	}
}
