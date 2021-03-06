package edu.asselvi.orcamentoobras.model.enumerator;

/**
 * Define o tipo de pessoa juntamente com o tamanho m�ximo que o documento 
 * identificador poder� conter
 * 
 * @author Marcelo Avancini
 *
 */
public enum ETipoPessoa {
	
	/**
	 * Tipo pessoa f�sica nacional
	 */
	FISICA(11, 'F', "Pessoa f�sica"),	
	/**
	 * Tipo pessoa juridica nacional
	 */
	JURIDICA(14, 'J', "Pessoa jur�dica");

	private final Integer lengthDocumento;
	private final Character sigla;
	private final String nomenclatura;
	
	private ETipoPessoa(Integer lengthDocumento, Character sigla, String nomenclatura) {
		this.lengthDocumento = lengthDocumento;
		this.sigla = sigla;
		this.nomenclatura = nomenclatura;
	}
	
	/**
	 * Tamanho m�ximo do documento da pessoa em quest�o definido 
	 * na constru��o do Objeto 
	 * 
	 * @return length m�ximo do documento
	 */
	public Integer getLengthDocumento() {
		return lengthDocumento;
	}
	
	public Character getSigla() {
		return sigla;
	}
	
	public String getNomenclatura() {
		return nomenclatura;
	}
	
	public static ETipoPessoa getPelaSigla(char sigla) {
		switch (sigla) {
			case 'F' : return FISICA;
			case 'J' : return JURIDICA;
		}
		
		return null;
	}
}