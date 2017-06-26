package inf221.trabalho.com.farrago.model;

import com.j256.ormlite.field.DatabaseField;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

import java.io.Serializable;
import org.greenrobot.greendao.DaoException;

@Entity
public class Ingresso implements Serializable {
    static final long serialVersionUID = 536871008;
    @Id(autoincrement = true)
    private Long id;
    private Long compradorId;
    @Property
    public String nomeDoEvento;
    @Property
    private long numero;
    @Property
    private int lote;
    @Property
    private float preco;
    @Property
    private float qrCode;
    @Property
    private String cidade;
    @Property
    private int tipoDeIngresso;

    // 0 -> ingresso do organizador | 1 -> ingresso vendedor


    public void setNumero(long numero) {
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

    public String getCidade() {
        return cidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }


    private boolean disponivel;
    public Ingresso() {
    }

    public Ingresso(Evento ev, Vendedor ven, int num, int lt, float pr, String cid, int tpI, boolean disp) {
        this.nomeDoEvento = ev.getNomeDoEvento();
        this.numero = num;
        this.lote = lt;
        this.preco = pr;
        this.cidade = cid;
        this.tipoDeIngresso = tpI;
        this.disponivel = disp;
    }

    @Generated(hash = 586174113)
    public Ingresso(Long id, Long compradorId, String nomeDoEvento, long numero, int lote, float preco,
            float qrCode, String cidade, int tipoDeIngresso, boolean disponivel) {
        this.id = id;
        this.compradorId = compradorId;
        this.nomeDoEvento = nomeDoEvento;
        this.numero = numero;
        this.lote = lote;
        this.preco = preco;
        this.qrCode = qrCode;
        this.cidade = cidade;
        this.tipoDeIngresso = tipoDeIngresso;
        this.disponivel = disponivel;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(Evento e) {
        nomeDoEvento = e.getNomeDoEvento();
    }


    public long getNumero() {
        return this.numero;
    }

    /**
     * @param numero
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Float getPreco() {
        return this.preco;
    }

    /**
     * @param preco
     */
    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getLote() {
        return this.lote;
    }

    /**
     * @param lote
     */
    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public int getTipoDeIngresso() {
        return this.tipoDeIngresso;
    }

    /**
     * @param tipoDeIngresso
     */
    public void setTipoDeIngresso(int tipoDeIngresso) {
        this.tipoDeIngresso = tipoDeIngresso;
    }

    public float getQrCode() {
        return qrCode;
    }

    public void setQrCode(float qrCode) {
        this.qrCode = qrCode;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompradorId() {
        return this.compradorId;
    }

    public void setCompradorId(Long compradorId) {
        this.compradorId = compradorId;
    }
}