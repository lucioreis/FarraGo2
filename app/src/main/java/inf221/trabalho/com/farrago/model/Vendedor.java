package inf221.trabalho.com.farrago.model;

import com.orm.SugarRecord;

import java.util.List;

import inf221.trabalho.com.farrago.modelBKP.Ingresso;

public class Vendedor extends SugarRecord {
	int idVendedor;
	private int cpf;
	private List<Ingresso> ingressosVenda;
	private int avaliacao;

	public Vendedor(){}

	public int getCpf() {
		return this.cpf;
	}

	/**
	 * 
	 * @param cpf
	 */
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public List<Ingresso> getIngressosVenda() {
		return this.ingressosVenda;
	}

	/**
	 * 
	 * @param ingressosVenda
	 */
	public void setIngressosVenda(List<Ingresso> ingressosVenda) {
		this.ingressosVenda = ingressosVenda;
	}

	public int getAvaliacao() {
		return this.avaliacao;
	}

	/**
	 * 
	 * @param avaliacao
	 */
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

}