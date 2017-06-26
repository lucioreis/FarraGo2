package inf221.trabalho.com.farrago.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import inf221.trabalho.com.farrago.R;

public class BuscaTab extends Fragment {
    private int resource;
    private Spinner spinnerNomeDoEvento, spinnerTag, spinnerTema, spinnerCidadesIngressoTab, spinnerCidadesEventoTab, spinnerFaixa;
    private ArrayAdapter<String> arrayCidade, arrayTag, arrayTema, arrayNome, arrayFaixa;

    public BuscaTab(int res){
        resource = res;
    }
    public BuscaTab(){}
    public static BuscaTab builder(int res){
        return new BuscaTab(res);
    }
    public BuscaTab arrayCidade(ArrayAdapter<String> _array){
        arrayCidade = _array;
        return this;
    }
    public BuscaTab arrayTag(ArrayAdapter<String> _array){
        arrayTag = _array;
        return this;
    }
    public BuscaTab arrayTema(ArrayAdapter<String> _array){
        arrayTema = _array;
        return this;
    }
    public BuscaTab arrayNomeDeEvento(ArrayAdapter<String> _array){
        arrayNome = _array;
        return this;
    }
    public BuscaTab arrayFaixa(ArrayAdapter<String> _array){
        arrayFaixa = _array;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstamce){
        Log.i("erro", "chamou o oncreateView");
        return inflater.inflate(resource, container, false);
    }
    private void fillSpinner(Spinner spin, ArrayAdapter<String> _arrayAdapter){
        if(_arrayAdapter != null && spin != null){ spin.setAdapter(_arrayAdapter);}
    }

    private void spinnerAdd(Spinner spin, List<String> l){
        if(l == null) return;
        if(spin == null) l.add("");
        try {
            if(spin.getSelectedItemPosition() == 0) return;
            l.add((String) spin.getSelectedItem());
        }catch (NullPointerException e){
            l.add("");
        }
    }

    private Spinner recoverSpinner(Integer r){
        if(r == null) return null;
        return (Spinner) getActivity().findViewById(r);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinnerCidadesEventoTab = recoverSpinner(R.id.spinner_busca_cidade);
        spinnerCidadesIngressoTab = recoverSpinner(R.id.spinner_busca_cidade_tabIngresso);
        spinnerTema = recoverSpinner(R.id.spinner_busca_tema);
        spinnerTag = recoverSpinner(R.id.spinner_busca_tag);
        spinnerNomeDoEvento = recoverSpinner(R.id.spinner_busca_evento);
        spinnerFaixa = recoverSpinner(R.id.spinner_busca_faixa);
        fillSpinner(spinnerCidadesEventoTab, arrayCidade);
        fillSpinner(spinnerCidadesIngressoTab, arrayCidade);
        fillSpinner(spinnerTema, arrayTema);
        fillSpinner(spinnerTag, arrayTag);
        fillSpinner(spinnerNomeDoEvento, arrayNome);
        fillSpinner(spinnerFaixa, arrayFaixa);
    }

    public String[] getFiltros() {
        ArrayList<String> itemSelecionados = new ArrayList<>();
        spinnerAdd(spinnerCidadesEventoTab, itemSelecionados);
        spinnerAdd(spinnerCidadesEventoTab, itemSelecionados);
        spinnerAdd(spinnerCidadesIngressoTab, itemSelecionados);
        spinnerAdd(spinnerTema, itemSelecionados);
        spinnerAdd(spinnerTag, itemSelecionados);
        spinnerAdd(spinnerNomeDoEvento, itemSelecionados);
        return (String[]) itemSelecionados.toArray();
    }

    public void fazerPesquisaPorIngresso(View v){
        startActivity(new Intent(getContext(), ResultadoDaBusca.class));
    }
}