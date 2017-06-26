package inf221.trabalho.com.farrago.model;

import android.util.Log;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.greenrobot.greendao.converter.PropertyConverter;

@Entity
public class Comprador {
       public static class GreenConverter implements PropertyConverter<List<Ingresso>, String> {
        @Override
        public List<Ingresso> convertToEntityProperty(String databaseValue) {
            Helper helper = Helper.getInstance();
            if (databaseValue == null) {
                return null;
            }
            else {
                List<String> lista = Arrays.asList(databaseValue.split(","));
                List<Ingresso> list = new ArrayList<>();
                for(String l: lista){
                    //String[] prop = l.split(",");
                        Ingresso j = helper.findIngressoPrId(Long.valueOf(l));
                        list.add(j);
                }
                Log.i("error", ""+list.get(0));
                return list;
            }
        }

        @Override
        public String convertToDatabaseValue(List<Ingresso> entityProperty) {
            if(entityProperty==null){
                return null;
            }
            else{
                StringBuilder sb = new StringBuilder();
                for( Ingresso j : entityProperty){
                    sb.append(j.getId()).append(",");
                }
                return sb.toString();
            }
        }
        }

        @Id
    @Generated
    private Long id;
    @Property
    private String nome;
    @Property
    private String telefone;
    @Property
    private String senha;
    @Property
    private String usuario;
    @Property
    private String email;
    @Property
    private int idComprador;
    @Property
    private int cpf;

    @Convert(converter = GreenConverter.class, columnType = String.class)
    private List<Ingresso> meusIngressos;
    public Comprador() {
    }

    @Generated(hash = 1034880866)
    public Comprador(Long id, String nome, String telefone, String senha, String usuario, String email,
            int idComprador, int cpf, List<Ingresso> meusIngressos) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.usuario = usuario;
        this.email = email;
        this.idComprador = idComprador;
        this.cpf = cpf;
        this.meusIngressos = meusIngressos;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {return usuario;}

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

    public int getIdComprador() {
        return this.idComprador;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setMeusIngressos(List<Ingresso> meusIngressos) {
        this.meusIngressos = meusIngressos;
    }

    public void addIngresso(Ingresso ingresso) {
        if (meusIngressos == null) meusIngressos = new ArrayList<>();
        meusIngressos.add(ingresso);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingresso> getMeusIngressos() {
        return this.meusIngressos;
    }

}