package com.example.dogfriends.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.dogfriends.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    private Timer tiempo;
    private TimerTask accion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

    }

    private void inicializar() {
        tiempo = new Timer();
        accion = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        };
        tiempo.schedule(accion,1000);
    }
}
