package com.example.jgajardo.creditobienraiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

//Activity Formulario
public class FormActivity extends AppCompatActivity {

    //Declaramos nuestros campos
    TextView tv1;
    TextView tv2;
    TextView tv3;
    String seleccionSpinner;
    Spinner spinner;
    RadioButton rb1;
    double valorPropiedad;
    String tipoCasa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Capturamos el valor de que tipo de casa es
        tipoCasa = getIntent().getStringExtra("tipoCasa");

        //Inicializamos nuestros campos con los id del layout
        spinner = (Spinner) findViewById(R.id.spinner);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tvd2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv1.setText(tipoCasa);

        //Creamos un array con diferentes bancos
        String[] opciones = {"Banco Chile", "Banco estado", "Banco Bci", "Banco BBCA"};
        //Seteamos nuestro adapter con el array opciones
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //Metodo que captura el valor selecionado del list view
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                seleccionSpinner = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Validaciones para setear los textview dependiendo de la eleccion de casa que se elija
        if(tv1.getText().toString().equals("0")){
            tv2.setText("Casa Base");
            tv3.setText("3200");
            valorPropiedad = 3200;
        }else if(tv1.getText().toString().equals("1")){
            tv2.setText("Casa Media");
            tv3.setText("3800");
            valorPropiedad = 3800;
        }else if(tv1.getText().toString().equals("2")) {
            tv2.setText("Casa Grande");
            tv3.setText("4100");
            valorPropiedad = 4100;
        }
    }

    //Metodo que checkea si es compra en verde
    public void compraEnVerde(){
        if(rb1.isChecked()){
            valorPropiedad = valorPropiedad - (valorPropiedad * 0.15);
        }else{
            valorPropiedad = valorPropiedad;
        }
    }

    //Metodo que indica el banco
    public void seleccionBanco(){
        if (!seleccionSpinner.equals("Banco BBCA")){
            valorPropiedad = valorPropiedad;
        }else{
            valorPropiedad = valorPropiedad - (valorPropiedad * 0.03);
        }
    }

    //Realizamos las diferentes validaciones para los casos del formulario
    public void resumen(View view){
        if (!seleccionSpinner.equals("Banco BBCA")){
            valorPropiedad = valorPropiedad;
            Intent resumen = new Intent(getApplicationContext(), ResumeActivity.class);
            resumen.putExtra("tipoCasa", tipoCasa);
            String precioCasa = String.valueOf(valorPropiedad);
            resumen.putExtra("valorPropiedad", precioCasa);
            resumen.putExtra("banco", seleccionSpinner);
            startActivity(resumen);
        }
        if (seleccionSpinner.equals("Banco BBCA") && rb1.isChecked()){
            valorPropiedad = valorPropiedad - (valorPropiedad * 0.03)- (valorPropiedad * 0.15);
            Intent resumen = new Intent(getApplicationContext(), ResumeActivity.class);
            resumen.putExtra("tipoCasa", tipoCasa);
            String precioCasa = String.valueOf(valorPropiedad);
            resumen.putExtra("compraVerde", "Compra en Verde");
            resumen.putExtra("valorPropiedad", precioCasa);
            resumen.putExtra("banco", seleccionSpinner);
            startActivity(resumen);
        }
        if(rb1.isChecked()){
            valorPropiedad = valorPropiedad - (valorPropiedad * 0.15);
            Intent resumen = new Intent(getApplicationContext(), ResumeActivity.class);
            resumen.putExtra("tipoCasa", tipoCasa);
            String precioCasa = String.valueOf(valorPropiedad);
            resumen.putExtra("compraVerde", "Compra en Verde");
            resumen.putExtra("valorPropiedad", precioCasa);
            resumen.putExtra("banco", seleccionSpinner);
            startActivity(resumen);
        }
        if(seleccionSpinner.equals("Banco BBCA")){
            valorPropiedad = valorPropiedad - (valorPropiedad * 0.03);
            Intent resumen = new Intent(getApplicationContext(), ResumeActivity.class);
            resumen.putExtra("tipoCasa", tipoCasa);
            String precioCasa = String.valueOf(valorPropiedad);
            resumen.putExtra("compraVerde", "Compra en Verde");
            resumen.putExtra("valorPropiedad", precioCasa);
            resumen.putExtra("banco", seleccionSpinner);
            startActivity(resumen);
        }

    }
}
