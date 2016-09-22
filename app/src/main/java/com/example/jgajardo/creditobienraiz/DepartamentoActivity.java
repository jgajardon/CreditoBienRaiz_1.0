package com.example.jgajardo.creditobienraiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DepartamentoActivity extends AppCompatActivity {

    //Declaramos nuestro list view para depto
    ListView listViewDepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento);

        //Al igual que en la casa, creamos nuestro objeto list view
        BienRaiz bienRaiz_datosdpto[] = new BienRaiz[]{
                new BienRaiz(R.drawable.ic_lasrosas, "Edificio Las Rosas"),
                new BienRaiz(R.drawable.ic_quelen, "Edificio Quelén"),
                new BienRaiz(R.drawable.ic_loscisnes, "Edificio Los Cisnes")
        };

        //Nuestro adapter que le pasaremos el array que creamos
        BienRaizAdapter adapter = new BienRaizAdapter(this, R.layout.listview_item_row, bienRaiz_datosdpto);
        listViewDepto = (ListView) findViewById(R.id.listViewDepto);
        listViewDepto.setAdapter(adapter);

        //Metodo que envia al nuevo activity
        listViewDepto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position == 0 || position == 1 || position ==2){
                    Intent newActivity1 = new Intent(getApplicationContext(), InfoDptoActivity.class);
                    startActivity(newActivity1);
                }
            }
        });
    }
}
