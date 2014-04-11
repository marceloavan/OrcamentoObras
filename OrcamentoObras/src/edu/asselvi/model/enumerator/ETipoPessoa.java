package edu.asselvi.model.enumerator;

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
	FISICA(11),	
	/**
	 * Tipo pessoa juridica nacional
	 */
	JURIDICA(14);

	private Integer lengthDocumento;
	
	private ETipoPessoa(Integer lengthDocumento) {
		this.lengthDocumento = lengthDocumento;
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
}
