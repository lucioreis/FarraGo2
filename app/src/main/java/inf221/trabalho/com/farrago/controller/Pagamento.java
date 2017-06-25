package inf221.trabalho.com.farrago.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import inf221.trabalho.com.farrago.R;
import inf221.trabalho.com.farrago.model.Comprador;
import inf221.trabalho.com.farrago.model.Evento;
import inf221.trabalho.com.farrago.model.FachadaSingleton;

public class Pagamento extends FragmentActivity {

    private Intent it;
    private FachadaSingleton fachadaSingleton = FachadaSingleton.getInstance();
        /**
         * The {@link android.support.v4.view.PagerAdapter} that will provide
         * fragments for each of the sections. We use a
         * {@link FragmentPagerAdapter} derivative, which will keep every
         * loaded fragment in memory. If this becomes too memory intensive, it
         * may be best to switch to a
         * {@link android.support.v4.app.FragmentStatePagerAdapter}.
         */
        private SectionsPagerAdapter mSectionsPagerAdapter;

        /**
         * The {@link ViewPager} that will host the section contents.
         */
        private ViewPager mViewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pagamento);
            // Create the adapter that will return a fragment for each of the three
            // primary sections of the activity.
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container_boleto);
            mViewPager.setAdapter(mSectionsPagerAdapter);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_boleto);
            tabLayout.setupWithViewPager(mViewPager);
            it = getIntent();


        }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_busca, container, false);
        }
    }

    public static class DefineLayoutToTabs extends Fragment {
        private int resource;
        public DefineLayoutToTabs(int res){
            resource = res;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstamce){
            return inflater.inflate(resource, container, false);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position) {
                case 0:
                    return new DefineLayoutToTabs(R.layout.activity_fragment_tab1);
                case 1:
                    return new DefineLayoutToTabs(R.layout.activity_fragment_tab2);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Cartão";
                case 1:
                    return "Boleto";
            }
            return null;
        }
    }

    public void efetuarCompraCartao(View v){
        Comprador comprador = fachadaSingleton.getComprador() ;
        Evento evento = (Evento) it.getSerializableExtra("evento");
        if(evento != null) {
            comprador.addIngresso(evento.getIngresso());
            evento.decrementaNumeroDeIngressos();
            comprador.update();
        }
        Toast.makeText(this, "Compra realizada com sucesso", Toast.LENGTH_LONG).show();
        Intent it2 = new Intent(this, CompradorTelaPrincipal.class);
        it2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        finish();
    }

    public void efetuarCompraBoleto(View v){
        //Nessa implementação basica eles vao fazer a mesma coisa
        efetuarCompraCartao(v);
    }
}
