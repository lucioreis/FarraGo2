package inf221.trabalho.com.farrago.model;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import org.greenrobot.greendao.DaoException;

@Entity
public class Evento implements Serializable {
	static final long serialVersionUID = 53687100;
	@Id
	private Long id;
	private Long ingressoId;
	private Long eventosId;
	@Property
	private String nomeDoEvento;
	@Property
	private String cidade;
	@Property
	private String data;
	@Property
	private String horario;
	@Property
	private int faixaEtaria;
	@ToOne(joinProperty = "ingressoId")
	private Ingresso ingresso;
	@Property
	private int numeroDeIngressos;
	@Property
	private String tag;
	@Property
	private String tema;
	/** Used to resolve relations */
	@Generated(hash = 2040040024)
	private transient DaoSession daoSession;
	/** Used for active entity operations. */
	@Generated(hash = 512378853)
	private transient EventoDao myDao;
	@Generated(hash = 1070527385)
	private transient Long ingresso__resolvedKey;

	public String getCidade() {
		return cidade;
	}

	public String getTag() {
		return tag;
	}

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

	@Generated(hash = 1688265074)
	public Evento(Long id, Long ingressoId, Long eventosId, String nomeDoEvento, String cidade,
			String data, String horario, int faixaEtaria, int numeroDeIngressos, String tag, String tema) {
		this.id = id;
		this.ingressoId = ingressoId;
		this.eventosId = eventosId;
		this.nomeDoEvento = nomeDoEvento;
		this.cidade = cidade;
		this.data = data;
		this.horario = horario;
		this.faixaEtaria = faixaEtaria;
		this.numeroDeIngressos = numeroDeIngressos;
		this.tag = tag;
		this.tema = tema;
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
		if(numeroDeIngressos <= 0) return;
		numeroDeIngressos = numeroDeIngressos - 1;
	}

	public void setTema(String tema){ this.tema = tema;}

	public  String getTema(){ return this.tema;}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIngressoId() {
		return this.ingressoId;
	}

	public void setIngressoId(Long ingressoId) {
		this.ingressoId = ingressoId;
	}

	public Long getEventosId() {
		return this.eventosId;
	}

	public void setEventosId(Long eventosId) {
		this.eventosId = eventosId;
	}

	/** To-one relationship, resolved on first access. */
	@Generated(hash = 1558522575)
	public Ingresso getIngresso() {
		Long __key = this.ingressoId;
		if (ingresso__resolvedKey == null || !ingresso__resolvedKey.equals(__key)) {
			final DaoSession daoSession = this.daoSession;
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			IngressoDao targetDao = daoSession.getIngressoDao();
			Ingresso ingressoNew = targetDao.load(__key);
			synchronized (this) {
				ingresso = ingressoNew;
				ingresso__resolvedKey = __key;
			}
		}
		return ingresso;
	}

	/** called by internal mechanisms, do not call yourself. */
	@Generated(hash = 1715273020)
	public void setIngresso(Ingresso ingresso) {
		synchronized (this) {
			this.ingresso = ingresso;
			ingressoId = ingresso == null ? null : ingresso.getId();
			ingresso__resolvedKey = ingressoId;
		}
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 128553479)
	public void delete() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.delete(this);
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 1942392019)
	public void refresh() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.refresh(this);
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 713229351)
	public void update() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.update(this);
	}

	public String getData() {
		return this.data;
	}

	public String getHorario() {
		return this.horario;
	}

	/** called by internal mechanisms, do not call yourself. */
	@Generated(hash = 1368520935)
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getEventoDao() : null;
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