package inf221.trabalho.com.farrago.model;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import inf221.trabalho.com.farrago.modelBKP.Perfil;

public class Organizador extends SugarRecord {

	private String nomeFantasia;
	private String nomeDaEmpresa;
	private int CNPJ;
	private String endereco;
	private String nome;
	private String telefone;
	private String senha;
	private String usuario;
	private String email;

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public Organizador(){}
	/**
	 * 
	 * @param nomeFantasia
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeDaEmpresa() {
		return this.nomeDaEmpresa;
	}

	/**
	 * 
	 * @param nomeDaEmpresa
	 */
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}

	public int getCNPJ() {
		return CNPJ;
	}

	/**
	 * 
	 * @param CNPJ
	 */
	public void setCNPJ(int CNPJ) {
		this.CNPJ = CNPJ;
	}

	public String getEndereco() {
		return this.endereco;
	}

	/**
	 * 
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}