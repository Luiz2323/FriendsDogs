package com.proyecto.pruebamenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] btIcono ={
            R.drawable.uno,
            R.drawable.dos,
            R.drawable.tres,
    };

    public String[] tvNombre = {
            "veterinaria",
            "notificaciones",
            "historias"
    };

    @Override
    public int getCount() {
        return tvNombre.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider,container,false);

        ImageButton slideButton=view.findViewById(R.id.ibIcono);
        TextView textView = view.findViewById(R.id.tvNombre);

        slideButton.setImageResource(btIcono[position] );
        textView.setText(tvNombre[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
