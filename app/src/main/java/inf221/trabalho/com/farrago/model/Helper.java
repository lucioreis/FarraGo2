package inf221.trabalho.com.farrago.model;

import android.app.Activity;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import inf221.trabalho.com.farrago.util.MyApp;


public final class Helper extends Activity{
    private static final Helper ourInst = new Helper();

    private String[] filtros;
    private List<Evento> resultadosDaBuscaPorEventos;
    private DaoSession daoSession;

    private Helper(){
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
         for( Evento e : eventos) {
             if(!elementos.contains(e.getCidade()))
                elementos.add(e.getLocal());}
         return elementos;
     }

     public ArrayList<String> getListaDeTags(){
         ArrayList<String> elementos = new ArrayList<>();
         List<Evento> eventos = getListaDeEventos();
         for( Evento e : eventos) elementos.add(e.getTag());
         return elementos;
     }


    public <T> Object findById(Class<T> c, Long id) {
        return daoSession.getDao(c).loadByRowId(id);
    }

    public Ingresso findIngressoPrId(Long id) {
        IngressoDao  ingressoDao = daoSession.getIngressoDao();
        return ingressoDao.loadByRowId(id);
    }

    private enum Filtro {
         CIDADE(1), DATA(4), TAG(2), TEMA(3), PADRAO(0);
         private final int i;
         Filtro(int k){
             i = k;
         }
         public int getI(){ return i;}
     }
     public void setSearchFiltro(String padrao, String cidade, String tema, String tag ){
         filtros = new String[5];
         if(padrao == null) padrao  = "";
         filtros[0] = padrao;
         if(cidade == null) cidade = "";
         filtros[Filtro.CIDADE.getI()] = cidade;
         filtros[Filtro.DATA.getI()] = "";
         if(tag == null) tag = "";
         filtros[Filtro.TAG.getI()] = tag;
         if(tema == null) padrao = "";
         filtros[Filtro.TEMA.getI()] = padrao;
     }
     public void search() {
         String whereClause = "";
         if(resultadosDaBuscaPorEventos == null) resultadosDaBuscaPorEventos = new ArrayList<Evento>();
         if(!resultadosDaBuscaPorEventos.isEmpty()) resultadosDaBuscaPorEventos.clear();
         QueryBuilder<Evento> qb;
         if(!filtros[Filtro.PADRAO.getI()].isEmpty())
           // qb.where(EventoDao.Properties.NomeDoEvento.eq(filtros[Filtro.PADRAO.getI()]));
         if (!filtros[Filtro.CIDADE.getI()].isEmpty())
           // qb.and(1, qb.where(EventoDao.Properties.NomeDoEvento.eq(filtros[Filtro.PADRAO.getI()])));
         if (!filtros[Filtro.DATA.getI()].isEmpty())
             whereClause += "data = ? ";
         if (!filtros[Filtro.TAG.getI()].isEmpty())
             whereClause += "tag = ? ";
         if (!filtros[Filtro.TEMA.getI()].isEmpty())
             whereClause += "tema = ? ";
         Log.i("errou", ""+filtros[0]);
         resultadosDaBuscaPorEventos = daoSession.getEventoDao().loadAll();
         EventoDao eventoDao = daoSession.getEventoDao();
         QueryBuilder.LOG_SQL = true;
         QueryBuilder.LOG_VALUES = true;
         Evento e = resultadosDaBuscaPorEventos.get(0);
         for(Evento j: resultadosDaBuscaPorEventos){
             if(j.getLocal().equals(e.getLocal()))
                Log.i("cidade", j.getLocal());
         }
         QueryBuilder<Evento> query = eventoDao.queryBuilder().where(EventoDao.Properties.Cidade.eq(filtros[1]));
//         qb.or(Properties.YearOfBirth.gt(1970),
//                         qb.and(Properties.YearOfBirth.eq(1970), Properties.MonthOfBirth.ge(10))));
         //resultadosDaBuscaPorEventos = query.list();//daoSession.getEventoDao().queryBuilder()
        // Log.i("tamanho",query.list().size()+ ""+resultadosDaBuscaPorEventos.size()+"  "+filtros[0]);
         resultadosDaBuscaPorEventos = query.list();

//                 .where(EventoDao.Properties.NomeDoEvento.eq(filtros[0]))
//                 .list();
     }
    public void searchUpdate(){
        resultadosDaBuscaPorEventos.clear();
        search();
    }
     public List<Evento> getResultadosDaPesquisaPorEventos(){
         return resultadosDaBuscaPorEventos;
     }
     public static Helper getInstance(){
         return ourInst;
     }
     public static Helper init(MyApp myApp){
         ourInst.daoSession = myApp.getDaoSession();
         return  ourInst;
     }
}
