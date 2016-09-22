package com.example.jgajardo.creditobienraiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//Activity que muestra los condominios de las casas
public class CasaActivity extends AppCompatActivity {

    //Declaramos nuestro listview
    ListView listViewCasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa);

        //Ocupamos nuestro objeto list view
        BienRaiz bienRaiz_datoscasa[] = new BienRaiz[]{
                //Le damos valores a nuestro listview
                new BienRaiz(R.drawable.ic_almendros, "Condominio Los Almendros"),
                new BienRaiz(R.drawable.ic_forest, "Condominio Los Pinos"),
                new BienRaiz(R.drawable.ic_villaalegre, "Condominio Villa Alegre")
        };

        //Creamos nuestro adapter para pasarle nuestro arreglo con los valores que ingresamos antes
        BienRaizAdapter adapter = new BienRaizAdapter(this, R.layout.listview_item_row, bienRaiz_datoscasa);
        listViewCasa = (ListView) findViewById(R.id.listViewCasa);
        listViewCasa.setAdapter(adapter);

        //Metodo que indica que en cualquier opciones enviara al nuevo activity
        listViewCasa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position == 0 || position == 1 || position ==2){
                    Intent newActivity1 = new Intent(getApplicationContext(), InfoCasaActivity.class);
                            startActivity(newActivity1);

                }
            }
        });
    }
}
