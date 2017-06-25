package inf221.trabalho.com.farrago.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import inf221.trabalho.com.farrago.util.MyApp;

import com.orm.SugarContext;
import com.orm.SugarRecord;

public final class FachadaSingleton{
    private static final FachadaSingleton ourInst = new FachadaSingleton();

    private List<String> nomeDeCidade, tags;
    private  List<Date> dataDasFestas = new ArrayList<>();
    private final Evento evento = new Evento();
    private final Comprador comprador = new Comprador();
    private final Organizador organizador = new Organizador();
    private String[] filtros;
    private List<Evento> resultadosDaBuscaPorEventos;

    private FachadaSingleton(){
        SugarContext.init(MyApp.getContext());
    }

    public Comprador getComprador(){
        return (new Comprador()).findById(Comprador.class, 1);
    }
    public List<Evento> getListaDeEventos(){
        return  SugarRecord.listAll(Evento.class);
    }
    public List<Organizador> getListaDeOrganizadores(){
        return  SugarRecord.listAll(Organizador.class);
    }
    public List<Vendedor> getListaDeVendedores(){
        return  SugarRecord.listAll(Vendedor.class);
    }
    public List<Ingresso> getListaDeIngresso(){
        return SugarRecord.listAll(Ingresso.class);
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

     private enum Filtro {
         CIDADE(0), DATA(1), TAG(2), TEMA(3), PADRAO(4);
         private final int i;
         Filtro(int k){
             i = k;
         }
         public int getI(){ return i;}
     }
     public void setSearchFiltro(String padrao, String cidade, String tema, String tag ){
         filtros = new String[4];
         filtros[Filtro.PADRAO.getI()] = padrao;
         filtros[Filtro.CIDADE.getI()] = cidade;
         filtros[Filtro.DATA.getI()] = "";
         filtros[Filtro.TAG.getI()] = tag;
         filtros[Filtro.TEMA.getI()] = padrao;
     }
     public void search() {
         String whereClause = "where ";
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
         ArrayList<String> aux = new ArrayList<>();
         for (String s : filtros) {
             if (!s.isEmpty()) aux.add(s);
         }
         resultadosDaBuscaPorEventos = SugarRecord.find(Evento.class, whereClause, (String[]) aux.toArray());
     }
     public List<Evento> getResultadosDaPesquisaPorEventos(){
         return resultadosDaBuscaPorEventos;
     }
     public static FachadaSingleton getInstance(){
         return ourInst;
     }
}
