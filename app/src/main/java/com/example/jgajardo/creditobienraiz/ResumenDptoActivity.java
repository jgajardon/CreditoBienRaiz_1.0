package com.example.jgajardo.creditobienraiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//Activity Resumen Depto
public class ResumenDptoActivity extends AppCompatActivity {
    //Inicializamos nuestros text views
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv6;
    TextView tv7;
    TextView tv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_dpto);

        //Enlazamos los valores con el id del layout
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);

        //Traemos los campos desde el activity anterior
        String tipoDpto = getIntent().getStringExtra("tipoDpto");
        String compraEnVerde = getIntent().getStringExtra("compraDptoVerde");
        String banco = getIntent().getStringExtra("banco");
        String valorDpto = getIntent().getStringExtra("valorPropiedad");

        //Validamos que tipo de depto es y lo seteamos
        if (tipoDpto.equals("0")) {
            tv1.setText("Dpto 100 mt2");
        }else{
            tv1.setText("Dpto 120 mt2");
        }

        //Seteamos los valores segun lo escogido
        tv2.setText(compraEnVerde);
        tv3.setText(banco);
        tv4.setText(valorDpto);
        tv6.setText("Tu Departamento ee :");
        tv7.setText("tu banco es: ");
        tv8.setText("el valor total en UF es : ");
    }
}
