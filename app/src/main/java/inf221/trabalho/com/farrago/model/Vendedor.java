package inf221.trabalho.com.farrago.model;


import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Vendedor {
	@Id private Long id;
	@Property  private int cpf;
	@ToMany(referencedJoinProperty = "ingressoId")
	@OrderBy("numerso ASC")
	private ArrayList<Ingresso> ingressosVenda;
	@Property  private int avaliacao;
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
	public void setIngressosVenda(ArrayList<Ingresso> ingressosVenda) {
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