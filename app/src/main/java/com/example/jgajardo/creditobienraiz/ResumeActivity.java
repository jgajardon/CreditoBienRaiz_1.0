package com.example.jgajardo.creditobienraiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//Activity Resumen de casa
public class ResumeActivity extends AppCompatActivity {

    //Inicializamos todos nuestros textview
    TextView tvCasa;
    TextView tvCompraEnVerde;
    TextView tvBanco;
    TextView tvValorAPagar;
    TextView tv1;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        //Los enlazamos con el id del layout
        tvCasa = (TextView) findViewById(R.id.tvCasa);
        tvCompraEnVerde = (TextView) findViewById(R.id.tvCompraEnVerde);
        tvBanco = (TextView) findViewById(R.id.tvBanco);
        tvValorAPagar = (TextView) findViewById(R.id.tvValorAPagar);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

        //Capturamos los datos del layout anterior
        String tipoCasa = getIntent().getStringExtra("tipoCasa");
        String compraEnVerde = getIntent().getStringExtra("compraVerde");
        String banco = getIntent().getStringExtra("banco");
        String valorPropiedad = getIntent().getStringExtra("valorPropiedad");

        //Validamos que tipo de casa es
        if(tipoCasa.equals("0")) {
            tvCasa.setText("Casa Base");
        }else if (tipoCasa.equals("1")){
            tvCasa.setText("Casa Media");
        }else if (tipoCasa.equals("2")){
            tvCasa.setText("casa Grande");
        }

        //Seteamos los valores escogidos
        tvCompraEnVerde.setText(compraEnVerde);
        tvBanco.setText(banco);
        tvValorAPagar.setText(valorPropiedad);
        tv1.setText("la casa seleccionada es :");
        tv2.setText("Tu banco es :");
        tv3.setText("El valor Total en UF es: ");
    }
}
