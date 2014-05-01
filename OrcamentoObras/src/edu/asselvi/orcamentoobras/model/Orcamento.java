package edu.asselvi.orcamentoobras.model;

import java.math.BigDecimal;
import java.util.List;

import edu.asselvi.orcamentoobras.model.abst.AbstractPessoa;
import edu.asselvi.orcamentoobras.model.intf.IOrcamento;

/**
 * Implementação padrão inicial de orçamentos
 * <br><br>
 * Objetivo: Todo orçamento deverá "orçar" os custos da obra de modo gerencial, ou seja,
 * armazenar os gastos e gerar valores de venda de acordo com regras definidas pela intf
 * principal.
 *
 * @author Marcelo Avancini
 *
 */
public class Orcamento implements IOrcamento {

	private Integer id;
	private String nome;
	private String descricao;
	
	private CustoUnitarioBasico cub;
	private Terreno terreno;
	private AbstractPessoa cliente;

	private Double metragemConstrucao;
	private List<Previsao> previsaoList;
	private Double percetualLucro;
	
	public Orcamento(Integer id, String nome, String descricao, CustoUnitarioBasico cub, Terreno terreno, Double metragemConstrucao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cub = cub;
		this.terreno = terreno;
		this.metragemConstrucao = metragemConstrucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCliente(AbstractPessoa cliente) {
		this.cliente = cliente;
	}

	public CustoUnitarioBasico getCub() {
		return cub;
	}

	public void setCub(CustoUnitarioBasico cub) {
		this.cub = cub;
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public Double getMetragemConstrucao() {
		return metragemConstrucao;
	}

	public void setMetragemConstrucao(Double metragemConstrucao) throws Exception {
		if (metragemConstrucao > getTerreno().getMetragem()) {
			// TODO criar exception especifica...
			throw new Exception();
		}
		this.metragemConstrucao = metragemConstrucao;
	}
	
	public List<Previsao> getPrevisaoList() {
		return previsaoList;
	}

	public void setPrevisaoList(List<Previsao> previsaoList) {
		this.previsaoList = previsaoList;
	}
	
	public Double getPercetualLucro() {
		return percetualLucro;
	}

	public void setPercetualLucro(Double percetualLucro) {
		this.percetualLucro = percetualLucro;
	}

	/**
	 * Retorna o valor total que representam as previsões de gasto
	 * 
	 * @return totalPrevisao - somatório do valor das previsões
	 */
	public BigDecimal getTotalPrevisao() {
		BigDecimal totalPrevisao = new BigDecimal(0);
		for (Previsao previsao : getPrevisaoList()) {
			totalPrevisao = totalPrevisao.add(previsao.getValor());
		}
		return totalPrevisao;
	}
	
	@Override
	public BigDecimal getValorVendaCub() {
		return getCub().getValorMetroQuadrado().multiply(new BigDecimal(getMetragemConstrucao()));
	}

	@Override
	public BigDecimal getValorVendaPrevisao() {
		return getTotalPrevisao().multiply(new BigDecimal(getPercetualLucro() / 100));
	}

	@Override
	public AbstractPessoa getCliente() {
		return cliente;
	}
}