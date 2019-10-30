package com.proyecto.pruebamenu;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    private ViewPager viewPager;
    private LinearLayout linear;

    private TextView[] contador;
    private SliderAdapter sliderAdapter;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        viewPager=view.findViewById(R.id.sliderViewPager);
        linear=view.findViewById(R.id.sliderMarcador);
        sliderAdapter= new SliderAdapter(getContext());
        viewPager.setAdapter(sliderAdapter);

        añadirContadores();
    }

    public void añadirContadores(){
        contador = new TextView[3];
        for(int i = 0; i<contador.length; i++){

            contador[i] = new TextView(getContext());
            contador[i].setText(Html.fromHtml("&#8226;"));
            contador[i].setTextSize(35);
            contador[i].setTextColor(getResources().getColor(R.color.colorCinco));

            linear.addView(contador[i]);
        }

    }
}
