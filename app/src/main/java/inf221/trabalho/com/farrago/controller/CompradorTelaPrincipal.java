package inf221.trabalho.com.farrago.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.j256.ormlite.stmt.query.In;

import java.util.List;

import inf221.trabalho.com.farrago.R;
import inf221.trabalho.com.farrago.model.Comprador;
import inf221.trabalho.com.farrago.model.CompradorDao;
import inf221.trabalho.com.farrago.model.DaoSession;
import inf221.trabalho.com.farrago.model.FachadaSingleton;
import inf221.trabalho.com.farrago.model.Ingresso;
import inf221.trabalho.com.farrago.model.IngressoDao;
import inf221.trabalho.com.farrago.model.Organizador;
import inf221.trabalho.com.farrago.util.MyApp;
import inf221.trabalho.com.farrago.util.PopulaBancoDeDados;

public class CompradorTelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprador_tela_principal);
        FachadaSingleton fachadaSingleton = FachadaSingleton.init((MyApp) getApplication());
//        if(fachadaSingleton.getListaDeOrganizadores().isEmpty()) {
        //          List<Organizador> organizadors = PopulaBancoDeDados.geraOrganizadores(5);
        //    }
        List<Organizador> organizador = PopulaBancoDeDados.geraOrganizadores(5);
    }

    public void pesquisar(View v){
        Intent it = new Intent(this, Busca.class);
        startActivity(it);
    }

    public void irParaMeusIngressos(View v){
        Intent it = new Intent(this, MeusIngressos.class);
        startActivity(it);
    }
}
