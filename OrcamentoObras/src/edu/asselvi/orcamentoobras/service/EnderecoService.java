package edu.asselvi.orcamentoobras.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import edu.asselvi.orcamentoobras.model.beans.Endereco;
import edu.asselvi.orcamentoobras.model.dao.factory.DaoFactory;
import edu.asselvi.orcamentoobras.model.dao.intf.IEnderecoDao;

public class EnderecoService {
	private IEnderecoDao enderecoDao;
	
	public EnderecoService(){
		enderecoDao = DaoFactory.getInstance().getEnderecoDao();
	}
	
	public List<Endereco> getTodos(){
		try {
			return enderecoDao.getTodos();
		} catch (SQLException e){
		}
		return Collections.emptyList();
		
	}
	
	public void inserirEndereco(Endereco endereco) {
		try {
			enderecoDao.inserir(endereco);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
		
	public void atualizarEndereco(Endereco endereco) {
		try {
			enderecoDao.atualizar(endereco);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluirEndereco (Integer codigo) {
		try {
			Endereco endereco = DaoFactory.getInstance().getEnderecoDao().getPeloCodigo(codigo);
			enderecoDao.remover(endereco);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Busca o endereço através do código, caso contrário retorna null
	 * 
	 * @param codigoEndereco
	 * @return
	 */
	public Endereco getById(Integer codigoEndereco) {
		try {
			return enderecoDao.getPeloCodigo(codigoEndereco);
		} catch (SQLException e) {
		}
		return null;
	}
	
}
