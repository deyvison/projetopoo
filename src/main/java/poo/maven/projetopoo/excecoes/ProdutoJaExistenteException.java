package poo.maven.projetopoo.excecoes;

public class ProdutoJaExistenteException extends RuntimeException {
	public ProdutoJaExistenteException(String msg) {
		super(msg);
	}
}