package inf221.trabalho.com.farrago.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.DaoException;
@Entity
public class Organizador {
	@Id private Long id;
	@Property private String nomeFantasia;
	@Property private String nomeDaEmpresa;
	@Property private int CNPJ;
	@Property private String endereco;
	@Property private String nome;
	@Property private String telefone;
	@Property private String senha;
	@Property private String usuario;
	@Property private String email;
	@ToMany(referencedJoinProperty = "eventosId")
	@OrderBy("nomeDoEvento ASC")
	private List<Evento> eventos;
	/** Used to resolve relations */
	@Generated(hash = 2040040024)
	private transient DaoSession daoSession;
	/** Used for active entity operations. */
	@Generated(hash = 145025964)
	private transient OrganizadorDao myDao;

	@Generated(hash = 327520068)
	public Organizador(Long id, String nomeFantasia, String nomeDaEmpresa, int CNPJ,
			String endereco, String nome, String telefone, String senha, String usuario,
			String email) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.nomeDaEmpresa = nomeDaEmpresa;
		this.CNPJ = CNPJ;
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
		this.usuario = usuario;
		this.email = email;
	}

	@Generated(hash = 1256260920)
	public Organizador() {
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}
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

	public void cadastraEvento(Evento e){
		if(eventos == null) eventos = new ArrayList<>();
		eventos.add(e);
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * To-many relationship, resolved on first access (and after reset).
	 * Changes to to-many relations are not persisted, make changes to the target entity.
	 */
	@Generated(hash = 519187060)
	public List<Evento> getEventos() {
		if (eventos == null) {
			final DaoSession daoSession = this.daoSession;
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			EventoDao targetDao = daoSession.getEventoDao();
			List<Evento> eventosNew = targetDao._queryOrganizador_Eventos(id);
			synchronized (this) {
				if (eventos == null) {
					eventos = eventosNew;
				}
			}
		}
		return eventos;
	}

	/** Resets a to-many relationship, making the next get call to query for a fresh result. */
	@Generated(hash = 708946329)
	public synchronized void resetEventos() {
		eventos = null;
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

	/** called by internal mechanisms, do not call yourself. */
	@Generated(hash = 131079373)
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getOrganizadorDao() : null;
	}
}