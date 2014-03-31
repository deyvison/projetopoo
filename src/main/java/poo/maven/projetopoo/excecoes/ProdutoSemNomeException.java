package poo.maven.projetopoo.excecoes;

public class ProdutoSemNomeException extends RuntimeException {
	public ProdutoSemNomeException(String msg) {
		super(msg);
	}
}
