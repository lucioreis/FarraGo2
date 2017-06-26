package inf221.trabalho.com.farrago.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import inf221.trabalho.com.farrago.R;
import inf221.trabalho.com.farrago.model.FachadaSingleton;
import inf221.trabalho.com.farrago.model.Evento;
import inf221.trabalho.com.farrago.model.Ingresso;
import inf221.trabalho.com.farrago.util.PersonalizadoArrayAdapter;

public class ResultadoDaBusca extends AppCompatActivity{
    private FachadaSingleton fachadaSingleton;
    List<Evento> eventos;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_resultado_da_busca);
        listView = (ListView) findViewById(R.id.lista_de_ingressos);
    }

    @Override
    public void onResume(){
        super.onResume();
        List<Ingresso> ingressos = new ArrayList<>();

        eventos = new ArrayList<>();

//            Evento evento = new Evento();
//            evento.setNomeDoEvento("Festa de aniversario de Coragen o Cão Covarde");
//            evento.setData(new java.sql.Date(11,11,11));
//            evento.setFaixaEtaria(11);
//            evento.setHorario(new Time(11,11,11));
//            evento.cadastraIngressos(11,11f,11,11);
//            evento.setLocal("Casa da Muriel");
//            evento.setNumeroDeIngressos(123);
//            evento.getIngresso().setNomeDoEvento(evento);
//            ingressos.add(evento.getIngresso());
//            eventos.add(evento);
//            eventos.add(evento);
        fachadaSingleton = FachadaSingleton.getInstance();
        fachadaSingleton.search();
        eventos.addAll(fachadaSingleton.getResultadosDaPesquisaPorEventos());
        PersonalizadoArrayAdapter arrayAdapter = new PersonalizadoArrayAdapter(eventos, this);

        listView.setAdapter(arrayAdapter);
        if(eventos.isEmpty()){
            Toast.makeText(this, "Nada Encontrado", Toast.LENGTH_LONG).show();
            finish();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity( ( new Intent(getBaseContext(), ComprarIngresso.class ))
                        .putExtra("eventoId", ((Evento) listView.getItemAtPosition(position)).getId()) );
            }
        });

    }

    public void voltar(View v){
        finish();
    }
}
