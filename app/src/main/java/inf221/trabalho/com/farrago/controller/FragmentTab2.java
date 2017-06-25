package inf221.trabalho.com.farrago.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import inf221.trabalho.com.farrago.R;

public class FragmentTab2 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_tab2, container, false);
        TextView tv = (TextView) v.findViewById(R.id.text);
        tv.setText("Um boleto foi enviado para o seu email!");
        return v;
    }
}