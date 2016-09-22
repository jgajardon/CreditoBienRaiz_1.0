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

//Activity Formulario Depto
public class FormDeptoActivity extends AppCompatActivity {

        //Inicializamos nuestro campos
        TextView tvd2;
        TextView tvd3;
        TextView tvd4;
        TextView tvd5;
        String seleccionSpinner;
        Spinner spinner;
        RadioButton rbd;
        double valorPropiedad;
        String tipoDpto;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_form_depto);

            //Capturamos el valor del tipo de depto
            tipoDpto = getIntent().getStringExtra("tipoDpto");

            //Inicializamos nuestros campos con los id del layout
            spinner = (Spinner) findViewById(R.id.spinner);
            tvd5 = (TextView) findViewById(R.id.tvd5);
            tvd3 = (TextView) findViewById(R.id.tvd3);
            tvd4 = (TextView) findViewById(R.id.tvd4);
            rbd = (RadioButton) findViewById(R.id.rbd);

            tvd2 = (TextView) findViewById(R.id.tvd2);
            tvd2.setText(tipoDpto);

            //Generamos un array para los bancos
            String[] opciones = {"Banco Chile", "Banco Estado", "Banco Bci", "Banco BBCA"};
            //Seteamos el adapter con las opciones
            spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                //Metodo que captura el valor del spinner
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    seleccionSpinner = (String) adapterView.getItemAtPosition(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            //Validaciones para cuando de elije el tipo de depto
            if (tvd2.getText().toString().equals("0")) {
                tvd5.setText("1000 uf");
                tvd4.setText("Dpto 100 mt2");
                valorPropiedad = 1000;
            }
            if (tvd2.getText().toString().equals("1")) {
                tvd5.setText("1200");
                tvd4.setText("Dpto 120 mt2");
                valorPropiedad = 1200;
            }
        }
            //Metodo para la compra en verde
            public void compraEnVerde(){
                if(rbd.isChecked()){
                    valorPropiedad = valorPropiedad - (valorPropiedad * 0.15);
                }else{
                    valorPropiedad = valorPropiedad;
                }
            }

            //Metodo para la seleccion de banco
            public void seleccionBanco(){
            if (!seleccionSpinner.equals("Banco BBCA")){
                valorPropiedad = valorPropiedad;
            }else{
                valorPropiedad= valorPropiedad - (valorPropiedad * 0.03);
                }
            }

        //Valicaciones para los diferentes casos del formulario
        public void resumenD(View view){
            if (!seleccionSpinner.equals("Banco BBCA")){
                valorPropiedad = valorPropiedad;
                Intent resumen = new Intent(getApplicationContext(), ResumenDptoActivity.class);
                resumen.putExtra("tipoDpto", tipoDpto);
                String precioDpto = String.valueOf(valorPropiedad);
                resumen.putExtra("valorPropiedad", precioDpto);
                resumen.putExtra("banco", seleccionSpinner);
                startActivity(resumen);
            }
            if (seleccionSpinner.equals("Banco BBCA") && rbd.isChecked()){
                valorPropiedad = valorPropiedad - (valorPropiedad * 0.03)- (valorPropiedad * 0.15);
                Intent resumen = new Intent(getApplicationContext(), ResumenDptoActivity.class);
                resumen.putExtra("tipoDpto", tipoDpto);
                String precioDpto = String.valueOf(valorPropiedad);
                resumen.putExtra("compraDptoVerde", "Compra en Verde");
                resumen.putExtra("valorPropiedad", precioDpto);
                resumen.putExtra("banco", seleccionSpinner);
                startActivity(resumen);
            }
            if(rbd.isChecked()){
                valorPropiedad = valorPropiedad - (valorPropiedad * 0.15);
                Intent resumen = new Intent(getApplicationContext(), ResumenDptoActivity.class);
                resumen.putExtra("tipoDpto", tipoDpto);
                String precioDpto = String.valueOf(valorPropiedad);
                resumen.putExtra("compraDptoVerde", "Compra en Verde");
                resumen.putExtra("valorPropiedad", precioDpto);
                resumen.putExtra("banco", seleccionSpinner);
                startActivity(resumen);
            }
            if(seleccionSpinner.equals("Banco BBCA")){
                valorPropiedad = valorPropiedad - (valorPropiedad * 0.03);
                Intent resumen = new Intent(getApplicationContext(), ResumenDptoActivity.class);
                resumen.putExtra("tipoDpto", tipoDpto);
                String precioDpto = String.valueOf(valorPropiedad);
                resumen.putExtra("compraDptoVerde", "Compra en Verde");
                resumen.putExtra("valorPropiedad", precioDpto);
                resumen.putExtra("banco", seleccionSpinner);
                startActivity(resumen);
            }
        }

}
