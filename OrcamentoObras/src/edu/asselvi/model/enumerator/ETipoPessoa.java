package edu.asselvi.model.enumerator;

/**
 * Define o tipo de pessoa juntamente com o tamanho m�ximo que o documento 
 * identificador poder� conter
 * 
 * @author Marcelo
 *
 */
public enum ETipoPessoa {
	
	/**
	 * Tipo pessoa f�sica nacional
	 */
	FISICA(11, 'F'),	
	/**
	 * Tipo pessoa juridica nacional
	 */
	JURIDICA(14, 'J');

	private final Integer lengthDocumento;
	private final Character sigla;
	
	private ETipoPessoa(Integer lengthDocumento, Character sigla) {
		this.lengthDocumento = lengthDocumento;
		this.sigla = sigla;
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
}