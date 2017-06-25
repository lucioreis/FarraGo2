package inf221.trabalho.com.farrago.model;

import com.j256.ormlite.field.DatabaseField;
import com.orm.SugarRecord;

import java.io.Serializable;


public class Ingresso extends SugarRecord implements Serializable {

	public int idIngresso;
	public Evento evento;
	private Vendedor vendedor;
	private int numero;
	private int lote;
	private float preco;

	public void setIdIngresso(int idIngresso) {
		this.idIngresso = idIngresso;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public int getIdIngresso() {
		return idIngresso;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public String getCidade() {
		return cidade;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	private String cidade;

	private int tipoDeIngresso;
	// 0 -> ingresso do organizador | 1 -> ingresso vendedor

	private boolean disponivel;

	public Ingresso() {}

	public Ingresso(Evento ev, Vendedor ven, int num, int lt, float pr, String cid, int tpI, boolean disp) {
		this.evento = ev;
		this.vendedor = ven;
		this.numero = num;
		this.lote = lt;
		this.preco = pr;
		this.cidade = cid;
		this.tipoDeIngresso = tpI;
		this.disponivel = disp;
	}

	public void setEvento(Evento e){
		evento = e;
	}
	public Evento getEvento(){
		return evento;
	}

	public Integer getNumero() {
		return this.numero;
	}

	/**
	 *
	 * @param numero
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Float getPreco() {
		return this.preco;
	}

	/**
	 *
	 * @param preco
	 */
	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getLote() {
		return this.lote;
	}

	/**
	 *
	 * @param lote
	 */
	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public int getTipoDeIngresso() {
		return this.tipoDeIngresso;
	}

	/**
	 *
	 * @param tipoDeIngresso
	 */
	public void setTipoDeIngresso(int tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	@Override
	public String toString(){
		return evento.getNomeDoEvento();
	}
}