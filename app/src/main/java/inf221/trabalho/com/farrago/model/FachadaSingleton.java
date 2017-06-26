package inf221.trabalho.com.farrago.model;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.annotation.NonNull;

import com.j256.ormlite.stmt.query.In;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import inf221.trabalho.com.farrago.util.MyApp;
import inf221.trabalho.com.farrago.util.PopulaBancoDeDados;



public final class FachadaSingleton extends Activity{
    private static final FachadaSingleton ourInst = new FachadaSingleton();

    private String[] filtros;
    private List<Evento> resultadosDaBuscaPorEventos;
    private DaoSession daoSession;

    private FachadaSingleton(){
    }


    public Comprador getComprador(){
        CompradorDao compradorDao = daoSession.getCompradorDao();
        Comprador comprador = compradorDao.load(1L);
        if(comprador == null) {
            comprador = new Comprador();
            comprador.setCpf(123456789);
            comprador.setEmail("email@email.com");
            comprador.setNome("Nome");
            comprador.setSenha("12345");
            comprador.setTelefone("2111");
            comprador.setUsuario("nome");
            daoSession.insert(comprador);
        }
        return comprador;
    }

    public void persiste(Object o){
        if(o instanceof Comprador){
            CompradorDao compradorDao = daoSession.getCompradorDao();
            Comprador comprador = (Comprador) o;
            compradorDao.insert(comprador);
        }else if (o instanceof  Ingresso){
             daoSession.getIngressoDao().insert((Ingresso) o);
        }else if(o instanceof Evento){
            daoSession.getEventoDao().insert((Evento) o);
        }else if(o instanceof Organizador){
            daoSession.getOrganizadorDao().insert((Organizador) o);
        }else return;
    }
    public void save(Object o){
        if(o instanceof Comprador){
            CompradorDao compradorDao = daoSession.getCompradorDao();
            Comprador comprador = (Comprador) o;
            compradorDao.save(comprador);
        }else if (o instanceof  Ingresso){
            daoSession.getIngressoDao().insert((Ingresso) o);
        }else if(o instanceof Evento){
            daoSession.getEventoDao().save((Evento) o);
        }else if(o instanceof Organizador){
            daoSession.getOrganizadorDao().save((Organizador) o);
        }else return;
    }

    public List<Evento> getListaDeEventos(){
        return daoSession.loadAll(Evento.class);
    }
    public List<Organizador> getListaDeOrganizadores(){
        return  daoSession.loadAll((Organizador.class));
    }
    public List<Vendedor> getListaDeVendedores(){
        return daoSession.loadAll(Vendedor.class);
    }
    public List<Ingresso> getListaDeIngresso(){
        return daoSession.loadAll(Ingresso.class);
    }
    public ArrayList<String> getListaDeCidades(){
         ArrayList<String> elementos = new ArrayList<>();
         List<Evento> eventos = getListaDeEventos();
         for( Evento e : eventos) elementos.add(e.getLocal());
         return elementos;
     }

     public ArrayList<String> getListaDeTags(){
         ArrayList<String> elementos = new ArrayList<>();
         List<Evento> eventos = getListaDeEventos();
         for( Evento e : eventos) elementos.add(e.getTag());
         return elementos;
     }

     public List getListAll(Object o){
          throw new UnsupportedOperationException();
     }

    public <T> Object findById(Class<T> c, Long id) {
        return daoSession.getDao(c).loadByRowId(id);
    }

    private enum Filtro {
         CIDADE(0), DATA(1), TAG(2), TEMA(3), PADRAO(4);
         private final int i;
         Filtro(int k){
             i = k;
         }
         public int getI(){ return i;}
     }
     public void setSearchFiltro(String padrao, String cidade, String tema, String tag ){
         filtros = new String[5];
         if(padrao == null) padrao  = "";
         filtros[Filtro.PADRAO.getI()] = padrao;
         if(cidade == null) cidade = "";
         filtros[Filtro.CIDADE.getI()] = cidade;
         filtros[Filtro.DATA.getI()] = "";
         if(tag == null) tag = "";
         filtros[Filtro.TAG.getI()] = tag;
         if(padrao == null) padrao = "";
         filtros[Filtro.TEMA.getI()] = padrao;
     }
     public void search() {
         String whereClause = "";
         if(resultadosDaBuscaPorEventos == null) resultadosDaBuscaPorEventos = new ArrayList<>();
         if(!resultadosDaBuscaPorEventos.isEmpty()) resultadosDaBuscaPorEventos.clear();

         if(!filtros[Filtro.PADRAO.getI()].isEmpty())
             whereClause += "nome_do_evento = ?";
         if (!filtros[Filtro.CIDADE.getI()].isEmpty())
             whereClause += "cidade = ? ";
         if (!filtros[Filtro.DATA.getI()].isEmpty())
             whereClause += "data = ? ";
         if (!filtros[Filtro.TAG.getI()].isEmpty())
             whereClause += "tag = ? ";
         if (!filtros[Filtro.TEMA.getI()].isEmpty())
             whereClause += "tema = ? ";
         String[] aux = new String[5];
         for (int i = 0; i < 5; i++){
             if (! filtros[i].isEmpty()) aux[i] = filtros[i];
         }
         resultadosDaBuscaPorEventos = getListaDeEventos();
       //  resultadosDaBuscaPorEventos = SugarRecord.find(Evento.class, whereClause, aux);
     }
    public void searchUpdate(){
        resultadosDaBuscaPorEventos.clear();
        search();
    }
     public List<Ingresso> getMeusIngressos(){
         throw new UnsupportedOperationException();
     }
     public List<Evento> getResultadosDaPesquisaPorEventos(){
         return resultadosDaBuscaPorEventos;
     }
     public static FachadaSingleton getInstance(){
         return ourInst;
     }
     public static FachadaSingleton init(MyApp myApp){
         ourInst.daoSession = myApp.getDaoSession();
         return  ourInst;
     }
}
