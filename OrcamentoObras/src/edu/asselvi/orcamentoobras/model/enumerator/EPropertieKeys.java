package edu.asselvi.orcamentoobras.model.enumerator;

/**
 * Contém todos as propriedades utilizadas pelo sistema.
 * Deve ser utilizado como fonte unica para propriedades.
 * 
 * @author Marcelo Avancini
 *
 */
public enum EPropertieKeys {
	
	DB_DATABASE_TYPE("db.database.type"),
	
	DB_HOST("db.host"),
	
	DB_PORT("db.port"),
	
	DB_USER("db.user"),
	
	DB_PASSWD("db.passwd"),
	
	DB_BASE("db.base");
	
	private final String propName;
	
	private EPropertieKeys(String propName) {
		this.propName = propName;
	}
	
	public String getPropName() {
		return propName;
	}
}
