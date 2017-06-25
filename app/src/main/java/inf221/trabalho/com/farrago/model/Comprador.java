package inf221.trabalho.com.farrago.model;

import com.j256.ormlite.field.DatabaseField;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import inf221.trabalho.com.farrago.modelBKP.Ingresso;
import inf221.trabalho.com.farrago.modelBKP.Perfil;
import inf221.trabalho.com.farrago.modelBKP.Vendedor;

public class Comprador extends SugarRecord implements Serializable {

	private String nome;
	private String telefone;
	private String senha;
	private String usuario;
	private String email;
	private int idComprador;
	private int cpf;
	private List<Ingresso> meusIngressos;

	public Comprador() {}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSenha() {
		return senha;
	}

	public String getUsuario() {
		return usuario;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}

	public String getEmail() {
		return email;
	}
	public int getCpf() {
		return this.cpf;
	}
	public int getIdComprador() { return this.idComprador; }

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public List<Ingresso> getMeusIngressos() {
		return this.meusIngressos;
	}

	public void setMeusIngressos(List<Ingresso> meusIngressos) {
		this.meusIngressos = meusIngressos;
	}

	public void addIngresso(Ingresso ingresso){
		if(meusIngressos == null) meusIngressos = new ArrayList<Ingresso>();
		meusIngressos.add(ingresso);
	}

}