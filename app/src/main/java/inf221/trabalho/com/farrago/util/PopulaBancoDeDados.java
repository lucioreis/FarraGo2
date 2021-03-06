package inf221.trabalho.com.farrago.util;

import android.os.SystemClock;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import inf221.trabalho.com.farrago.R;
import inf221.trabalho.com.farrago.model.Evento;
import inf221.trabalho.com.farrago.model.Helper;
import inf221.trabalho.com.farrago.model.Ingresso;
import inf221.trabalho.com.farrago.model.Organizador;
import inf221.trabalho.com.farrago.model.Vendedor;

/**
 * Created by lucio on 6/24/2017.
 */

public class PopulaBancoDeDados {
    private Evento evento;
    private Organizador organizador;
    private Vendedor vendedor;
    private Helper helper = null;

    private static String geraStringAleatoria(){
        String retorno  = "";
        java.util.Random r = new java.util.Random();
        r.setSeed(SystemClock.uptimeMillis());
        byte[] bytes = new byte[8];

        r.nextBytes(bytes);

        for(byte i : bytes)
            retorno += ((char)(i<0?i*-1:i));
        return retorno;
    }

    private static int geraIntAleatorio(){
        java.util.Random r = new java.util.Random();
        r.setSeed(SystemClock.uptimeMillis());
        int inteiro;
        inteiro = r.nextInt()%10;
        return Math.abs(inteiro);
    }

    private static String cidadeAleatoriaDeUmBanco(){
        return cidadeAleatoriaDeUmBanco(geraIntAleatorio()%3 + 1);

    }

    private static String cidadeAleatoriaDeUmBanco(int q){
        String s[] = {"Ponte Nova", "Acapulco", "Itabirito", "Nova York", "Joao Monlevade", "Ubá", "São Paulo", "Ribeirão Preto", "Juíz de Fora", "bola"};
        int tamanho = q;
        String retorno = "";
        for(int i =0; i< tamanho; i++){
            retorno = s[geraIntAleatorio()];
        }
        return retorno;
    }
    private static String stringAleatoriaDeUmBanco(int q){
        String s[] = {"festa", "casa", "amarelo", "joao", "aniverario", "porta", "bebida", "quarto", "galpão", "bola"};
        int tamanho = q;
        String retorno = "";
        for(int i =0; i< tamanho; i++){
            retorno += " " + s[geraIntAleatorio()];
        }
        return retorno;
    }

    private  static String stringAleatoriaDeUmBanco(){
        return stringAleatoriaDeUmBanco(geraIntAleatorio()%3 + 1);
    }


    public static List<Organizador> geraOrganizadores(int quantidae){
        List<Organizador> organizadores = new ArrayList<>(quantidae);
        Helper helper = Helper.getInstance();
        for(int i = 0; i<quantidae;i++){
            Organizador organizador = new Organizador();
            organizador.setNomeDaEmpresa(geraStringAleatoria());
            organizador.setNomeFantasia(geraStringAleatoria());
            organizador.setCNPJ(geraIntAleatorio());
            organizador.setEndereco(geraStringAleatoria());
            Evento evento = geraEventoAleatorio(1).get(0);
            evento.setEventosId(organizador.getId());
            helper.persiste(evento);
            organizador.cadastraEvento(evento);
            helper.persiste(organizador);
            organizadores.add(organizador);
        }
        return organizadores;
    }

    public static List<Evento> geraEventoAleatorio(int quantidade){
        List<Evento> eventos = new ArrayList<>(quantidade);
        Helper helper = Helper.getInstance();
        for(int i = 0; i < quantidade; i++){
            Evento evento = new Evento();
            evento.setNomeDoEvento(stringAleatoriaDeUmBanco(1));
            evento.setLocal(cidadeAleatoriaDeUmBanco(1));
            evento.setNumeroDeIngressos(geraIntAleatorio()*23);
            evento.setData(new Date(geraIntAleatorio(), geraIntAleatorio(), geraIntAleatorio()).toString());
            evento.setHorario(new Time(SystemClock.elapsedRealtime()).toString());
            evento.setCidade(cidadeAleatoriaDeUmBanco(1));
            evento.setFaixaEtaria(geraIntAleatorio());
            evento.setTag(stringAleatoriaDeUmBanco());
            evento.setTema(stringAleatoriaDeUmBanco());
            Ingresso ingresso = geraIngressoAleatorio(evento);
            evento.setIngressoId(ingresso.getId());
            helper.persiste(ingresso);
            evento.setIngresso(ingresso);
            eventos.add(evento);
        }
        return eventos;
    }

    public static Ingresso geraIngressoAleatorio(Evento evento){
        Ingresso ingresso = new Ingresso();
        int qrcodes[] = new int[4];
        qrcodes[0] = R.drawable.qr1;
        qrcodes[1] = R.drawable.qr2;
        qrcodes[2] = R.drawable.qr3;
        qrcodes[3] = R.drawable.qr4;
        ingresso.setNomeDoEvento(evento.getNomeDoEvento());
        ingresso.setCidade(evento.getCidade());
        ingresso.setDisponivel(true);
        ingresso.setLote(geraIntAleatorio()*geraIntAleatorio()*geraIntAleatorio()*geraIntAleatorio());
        ingresso.setPreco((float)100);
        ingresso.setTipoDeIngresso(geraIntAleatorio()%3);
        ingresso.setNumero(new java.util.Random().nextInt());
        ingresso.setQrCode(qrcodes[Math.abs(geraIntAleatorio()%4)]);
        return ingresso;
    }
}
