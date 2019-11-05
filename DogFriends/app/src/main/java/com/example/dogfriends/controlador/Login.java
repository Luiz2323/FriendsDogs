package com.example.dogfriends.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.dogfriends.R;

public class Login extends AppCompatActivity {
    private ImageView logo;
    private Animation scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializar();
    }

    private void inicializar() {
        logo = findViewById(R.id.logo);
        scale = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
        logo.startAnimation(scale);


    }
}
