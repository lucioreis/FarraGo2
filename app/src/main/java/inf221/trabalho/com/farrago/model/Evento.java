package inf221.trabalho.com.farrago.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


public class Evento extends SugarRecord implements Serializable {
	public String nomeDoEvento;

	public String cidade;

	public String data;

	public String horario;

	public int faixaEtaria;

	public Ingresso ingresso;

	public int numeroDeIngressos;

	public String getCidade() {
		return cidade;
	}

	public String getTag() {
		return tag;
	}

	public String tag;

	public Evento(){}

	public Evento(String nEv, String cid, Date dt, Time h, int fxE, Ingresso ing, int nIng){
		this.nomeDoEvento = nEv;
		this.cidade = cid;
		this.data = dt.toString();
		this.horario = h.toString();
		this.faixaEtaria = fxE;
		this.ingresso = ing;
		this.numeroDeIngressos = nIng;
	}

	public String getNomeDoEvento() {
		return this.nomeDoEvento;
	}

	/**
	 *
	 * @param nomeDoEvento
	 */
	public void setNomeDoEvento(String nomeDoEvento) {
		this.nomeDoEvento = nomeDoEvento;
	}

	public String getLocal() {
		return this.cidade;
	}

	/**
	 *
	 * @param local
	 */
	public void setLocal(String local) {
		this.cidade = local;
	}

	public Date getData() {
		return new Date(Date.parse(this.data));
	}

	/**
	 *
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data.toString();
	}

	public Time getHorario() {
		return new Time(Time.parse(this.horario));
	}

	/**
	 *
	 * @param horario
	 */
	public void setHorario(Time horario) {
		this.horario = horario.toString();
	}

	public int getFaixaEtaria() {
		return this.faixaEtaria;
	}

	/**
	 *
	 * @param faixaEtaria
	 */
	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public Ingresso getIngresso() {
		return this.ingresso;
	}

	/**
	 *
	 * @param ingresso
	 */
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public int getNumeroDeIngressos() {
		return this.numeroDeIngressos;
	}

	/**
	 *
	 * @param numeroDeIngressos
	 */
	public void setNumeroDeIngressos(int numeroDeIngressos) {
		this.numeroDeIngressos = numeroDeIngressos;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	public void decrementaNumeroDeIngressos(){
		if(numeroDeIngressos > 0) numeroDeIngressos -= 1;
	}

	/**
	 *
	 * @param numeroDeIngressos
	 * @param preco
	 * @param tipoDeIngresso
	*//*
	public void cadastraIngressos(int numeroDeIngressos, float preco, int lote, int tipoDeIngresso) {
		ingresso = new Ingresso(numeroDeIngressos, preco, lote, tipoDeIngresso);
		this.numeroDeIngressos = numeroDeIngressos;
	}*/

}