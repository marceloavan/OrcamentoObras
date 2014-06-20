package edu.asselvi.orcamentoobras.view.components.table.model;

/**
 * Define os m�todos para um conversor de objetos para modelos de tabela 
 * 
 * @author Marcelo Avancini
 *
 * @param <T> objeto (type) a ser convertido
 */
public interface IModelConverter<T> {
	
	/**
	 * Define as colunas que ser�o visulizadas
	 * @return
	 */
	public String[] getColumnNames();
	
	/**
	 * Dados que ser�o informados seguindo a sequencia de colunas
	 * 
	 * @return
	 */
	public Object[][] getData();
	
	/**
	 * Deve retornar o objeto convertido consinderando o indice da linhas selecionada (row).
	 * 
	 * @param index
	 * @return T object
	 */
	public T getObjectByRowIndex(int index);
	
}
