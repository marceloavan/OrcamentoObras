package edu.asselvi.model.enumerator;

/**
 * Define o tipo de pessoa juntamente com o tamanho máximo que o documento 
 * identificador poderá conter
 * 
 * @author Marcelo Avancini
 *
 */
public enum ETipoPessoa {
	
	/**
	 * Tipo pessoa física nacional
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
	 * Tamanho máximo do documento da pessoa em questão definido 
	 * na construção do Objeto 
	 * 
	 * @return length máximo do documento
	 */
	public Integer getLengthDocumento() {
		return lengthDocumento;
	}
}
