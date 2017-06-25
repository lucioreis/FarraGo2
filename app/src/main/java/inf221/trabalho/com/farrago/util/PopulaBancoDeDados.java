package inf221.trabalho.com.farrago.util;

import android.os.SystemClock;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Timer;

import inf221.trabalho.com.farrago.model.Evento;
import inf221.trabalho.com.farrago.model.Organizador;
import inf221.trabalho.com.farrago.model.Vendedor;

/**
 * Created by lucio on 6/24/2017.
 */

public class PopulaBancoDeDados {
    private Evento evento;
    private Organizador organizador;
    private Vendedor vendedor;

    private String geraStringAleatoria(){
        String retorno  = "";
        java.util.Random r = new java.util.Random();
        r.setSeed(SystemClock.uptimeMillis());
        byte[] bytes = new byte[8];

        r.nextBytes(bytes);

        for(byte i : bytes)
            retorno += ((char)(i<0?i*-1:i));
        return retorno;
    }

    private int geraIntAleatorio(){
        java.util.Random r = new java.util.Random();
        r.setSeed(SystemClock.uptimeMillis());
        int inteiro;
        inteiro = r.nextInt()%10;
        return inteiro;
    }

    private String stringAleatoriaDeUmBanco(){
        String s[] = {"festa", "casa", "amarelo", "joao", "aniverario", "porta", "bebida", "quarto", "galpão", ""};
        int tamanho = geraIntAleatorio();
        String retorno = "";
        for(int i =0; i< tamanho; i++){
            retorno += s[geraIntAleatorio()];
        }
        return retorno;
    }

    public List<Organizador> geraOrganizadores(int quantidae){
        for(int i = 0; i<quantidae;i++){
            Organizador organizador = new Organizador();
            organizador.setNomeDaEmpresa(geraStringAleatoria());
            organizador.setNomeFantasia(geraStringAleatoria());
            organizador.setCNPJ(geraIntAleatorio());
            organizador.setEndereco(geraStringAleatoria());
        }
        return null;
    }

}
