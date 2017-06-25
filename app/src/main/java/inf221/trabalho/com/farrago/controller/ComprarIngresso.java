package inf221.trabalho.com.farrago.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.orm.SchemaGenerator;
import com.orm.SugarApp;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.sql.Date;
import java.sql.Time;

import inf221.trabalho.com.farrago.R;
import inf221.trabalho.com.farrago.modelBKP.Evento;

public class ComprarIngresso extends AppCompatActivity {
    private Evento evento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comprar_ingresso);
        Intent it = getIntent();
        evento = (Evento) it.getSerializableExtra("evento");
        if(evento == null){
            evento = new Evento();
            evento.setData(new Date(11,11,11));
            evento.setFaixaEtaria(11);
            evento.setHorario(new Time(11,11,11));
            //evento.cadastraIngressos(11,11f,11,11);
            evento.setLocal("Casa da Muriel");
            evento.setNumeroDeIngressos(123);
        }
        ((TextView) findViewById(R.id.nome_da_festa)).setText(evento.getNomeDoEvento());
        ((TextView) findViewById(R.id.data_da_festa)).setText("Data: " + evento.getData().toString());
        ((TextView) findViewById(R.id.local_da_festa)).setText(evento.getLocal());
        ((TextView) findViewById(R.id.hora_da_festa)).setText("Hora: " + evento.getHorario().toString());
        ((TextView) findViewById(R.id.valor_do_ingresso)).setText("Preço: " + evento.getIngresso().getPreco().toString());
        ((TextView) findViewById(R.id.faixa_etaria_da_festa)).setText("Faixa Etária: " + ((Integer) evento.getFaixaEtaria()).toString());
        ((TextView) findViewById(R.id.ingressos_disponiveis)).setText("Ingressos disponiveis: " + evento.getNumeroDeIngressos());
    }

    public void efetuarCompra(View v){
        Intent it = new Intent(this, Pagamento.class);
        if(evento != null)
            it.putExtra("evento", evento);
        startActivity(it);
        finish();
    }

    public void cancelar(View v){
        finish();
    }
}
