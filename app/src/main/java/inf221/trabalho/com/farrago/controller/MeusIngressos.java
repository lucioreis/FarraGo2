package inf221.trabalho.com.farrago.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.j256.ormlite.dao.DaoManager;

import org.greenrobot.greendao.annotation.ToMany;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import inf221.trabalho.com.farrago.R;
import inf221.trabalho.com.farrago.model.Comprador;
import inf221.trabalho.com.farrago.model.CompradorDao;
import inf221.trabalho.com.farrago.model.DaoMaster;
import inf221.trabalho.com.farrago.model.DaoSession;
import inf221.trabalho.com.farrago.model.Evento;
import inf221.trabalho.com.farrago.model.FachadaSingleton;
import inf221.trabalho.com.farrago.model.Ingresso;
import inf221.trabalho.com.farrago.util.MyApp;
import inf221.trabalho.com.farrago.util.PersonalizadoArrayAdapter;

public class MeusIngressos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_ingressos);
        final ListView listView = (ListView) findViewById(R.id.lista_de_ingressos);
        List<Ingresso> ingressos = new ArrayList<>();
        FachadaSingleton fachadaSingleton = FachadaSingleton.getInstance();
        Comprador comprador = fachadaSingleton.getComprador();
        Log.i("qwert", ""+comprador.getCpf());
       // comprador.addIngresso(ingresso);
        if(comprador.getMeusIngressos() == null){
            Toast.makeText(this, "Voce ainda nao possui ingressos", Toast.LENGTH_LONG).show();
            finish();
        }else {
            PersonalizadoArrayAdapter arrayAdapter = new PersonalizadoArrayAdapter(comprador.getMeusIngressos(), this);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    createPopupImage(listView, position);
                }
            });
        }
    }

    public void createPopupImage(ListView listView, int position) {
        Ingresso i = (Ingresso) listView.getItemAtPosition(position);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        AlertDialog.Builder imageDialog = new AlertDialog.Builder(this);
        View layout = inflater.inflate(R.layout.popup_imagem,null);
        ImageView image = ((layout.findViewById(R.id.qrCode) != null)) ? (ImageView) layout.findViewById(R.id.qrCode) : null;
        if(image != null){
            image.setImageResource(R.drawable.qr3);
            image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        imageDialog.setView(layout);
        imageDialog.setPositiveButton("Return", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        imageDialog.create();
        imageDialog.show();
    }


    public void voltar(View v){
        finish();
    }


}
