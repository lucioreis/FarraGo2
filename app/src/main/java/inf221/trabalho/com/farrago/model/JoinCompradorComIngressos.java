package inf221.trabalho.com.farrago.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lucio on 6/25/2017.
 */
@Entity
public class JoinCompradorComIngressos {
    @Id
    private Long id;
    private Long ingressoId;
    private Long compradorId;
    @Generated(hash = 2110523206)
    public JoinCompradorComIngressos(Long id, Long ingressoId, Long compradorId) {
        this.id = id;
        this.ingressoId = ingressoId;
        this.compradorId = compradorId;
    }
    @Generated(hash = 1532330634)
    public JoinCompradorComIngressos() {
    }
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
    public Long getCompradorId() {
        return this.compradorId;
    }
    public void setCompradorId(Long compradorId) {
        this.compradorId = compradorId;
    }
}
