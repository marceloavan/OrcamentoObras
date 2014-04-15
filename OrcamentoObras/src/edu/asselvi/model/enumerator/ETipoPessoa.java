package edu.asselvi.model.enumerator;

/**
 * Define o tipo de pessoa juntamente com o tamanho máximo que o documento 
 * identificador poderá conter
 * 
 * @author Marcelo
 *
 */
public enum ETipoPessoa {
	
	/**
	 * Tipo pessoa física nacional
	 */
	FISICA(11, 'F', "Pessoa física"),	
	/**
	 * Tipo pessoa juridica nacional
	 */
	JURIDICA(14, 'J', "Pessoa jurídica");

	private final Integer lengthDocumento;
	private final Character sigla;
	private final String nomenclatura;
	
	private ETipoPessoa(Integer lengthDocumento, Character sigla, String nomenclatura) {
		this.lengthDocumento = lengthDocumento;
		this.sigla = sigla;
		this.nomenclatura = nomenclatura;
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
	
	public Character getSigla() {
		return sigla;
	}
	
	public String getNomenclatura() {
		return nomenclatura;
	}
}