package com.example.dogfriends.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dogfriends.R;

public class DogPin extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout layout;
    private TextView[] circulos = new TextView[4];
    private String[] lista =new String[4];
    private Button btn1,btn2,btn3,btn4,btn5,btn6;
    private Button btn7,btn8,btn9,btn0,btnok,btnlimpiar;
    private int contador =-1;
    private ImageView candado;
    private  String password ="1234";
    private Animation animation;
    private AlphaAnimation alphaAnimation;

    private boolean limpiar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_pin);
        inicializar();
    }
        private void inicializar() {
            //instancio mi vista
            layout = findViewById(R.id.contenedor);
            btn1 = findViewById(R.id.btn1);
            btn2 = findViewById(R.id.btn2);
            btn3 = findViewById(R.id.btn3);
            btn4 = findViewById(R.id.btn4);
            btn5 = findViewById(R.id.btn5);
            btn6 = findViewById(R.id.btn6);
            btn7 = findViewById(R.id.btn7);
            btn8 = findViewById(R.id.btn8);
            btn9 = findViewById(R.id.btn9);
            btn0 = findViewById(R.id.btn0);
            btnok = findViewById(R.id.btnok);
            btnlimpiar = findViewById(R.id.btnlimpiar);
            candado = findViewById(R.id.candado);
            alphaAnimation = new AlphaAnimation(1,0);

            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);
            btn5.setOnClickListener(this);
            btn6.setOnClickListener(this);
            btn7.setOnClickListener(this);
            btn8.setOnClickListener(this);
            btn9.setOnClickListener(this);
            btn0.setOnClickListener(this);
            btnok.setOnClickListener(this);
            btnlimpiar.setOnClickListener(this);

            animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);




        }
//funcion que me permite crear los circulos blancos
        private void crearCircuos(String numero) {
            contador = contador+1;
            if (contador >=4){
                contador=circulos.length-1;

            }else {


                int i =contador;

                lista[i]=numero;
                circulos[i] = new TextView(getApplicationContext());
                circulos[i].setText(Html.fromHtml("&#8226"));
                circulos[i].setTextSize(75);
                circulos[i].setY(410);
                circulos[i].setX(340+i*100);
                circulos[i].setTextColor(Color.parseColor("#D52727"));
                layout.addView(circulos[i]);


            }


        }
        //obtengo la informacion de cada boton oprimido dentro del switch
        @Override
        public void onClick(View view) {
            String numero;


            switch (view.getId()){
                case R.id.btn1:
                    numero ="1";

                    crearCircuos(numero);

                    break;
                case R.id.btn2:
                    numero ="2";

                    crearCircuos(numero);

                    break;
                case R.id.btn3:
                    numero ="3";

                    crearCircuos(numero);

                    break;
                case R.id.btn4:

                    numero ="4";

                    crearCircuos(numero);

                    break;

                case R.id.btn5:
                    numero ="5";

                    crearCircuos(numero);

                    break;
                case R.id.btn6:
                    numero ="6";

                    crearCircuos(numero);

                    break;

                case R.id.btn7:
                    numero ="7";

                    crearCircuos(numero);

                    break;
                case R.id.btn8:
                    numero ="8";

                    crearCircuos(numero);

                    break;

                case R.id.btn9:
                    numero ="9";

                    crearCircuos(numero);

                    break;
                case R.id.btn0:
                    numero ="0";

                    crearCircuos(numero);

                    break;
                case R.id.btnok:
                    contador=contador-1;
                    comprobacion();
                    break;
                case R.id.btnlimpiar:

                    limpiar = true;
                    limpiar(circulos);

                    break;
            }

        }

        //borro los digitos ingresados desde el ultimo al primero

        private void limpiar(TextView[] circulos) {
            if (contador >=4){
                contador=circulos.length;
            }
            if (contador!=-1){
                int i =contador;
                Toast.makeText(this, ""+contador, Toast.LENGTH_SHORT).show();
                layout.removeView(circulos[i]);
                lista[i] ="";
                contador = contador-1;




            }

            limpiar = false;

        }



        //realizo la comprobacion si la contraseña es correcta al presionar el boton ok
        private void comprobacion() {
            contador++;
            String ten="";
            for (String temporal:lista) {
                ten =ten + temporal;



            }

            if (ten.equals(password)){
                ((TransitionDrawable)candado.getDrawable()).startTransition(1000);
                Toast.makeText(this, "Contraseña correta", Toast.LENGTH_SHORT).show();

            }else {for (int j = 0;j<circulos.length;j++){
                layout.removeView(circulos[j]);
            }

                for (int i = 0 ;i<=contador;i++) {
                    circulos[i] = new TextView(getApplicationContext());
                    circulos[i].setText(Html.fromHtml("&#8226"));
                    circulos[i].setTextSize(75);
                    circulos[i].setY(410);
                    circulos[i].setX(340+i*100);
                    circulos[i].setTextColor(Color.RED);
                    layout.addView(circulos[i]);
                    circulos[i].startAnimation(animation);
                }






            }
        }

    }
