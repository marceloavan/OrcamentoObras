package edu.asselvi.orcamentoobras.model.dao.intf;

import java.sql.SQLException;

import edu.asselvi.orcamentoobras.model.beans.CustoUnitarioBasico;

/**
 * Comportamento padrão de DAOs para trabalhar com {@link CustoUnitarioBasico}
 * 
 * @author Leandro Rebelo
 *
 */

public interface ICustoUnitarioBasicoDao extends IDao<CustoUnitarioBasico>{
	
	public CustoUnitarioBasico getPeloMesAno (Integer mes, Integer ano) throws SQLException;
	
	public CustoUnitarioBasico getPeloCodigo (Integer codigo) throws SQLException;

}
