package com.example.jgajardo.creditobienraiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//Activity Tipo Depto
public class InfoDptoActivity extends AppCompatActivity {

    //Declaramos nuestro list view para los deptos
    ListView listViewInfoDepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_dpto);

        //Creamos nuestro list view para los deptos
        BienRaiz bienRaiz_datosinfodpto[] = new BienRaiz[]{
                new BienRaiz(R.drawable.ic_s_dpto, "Dpto 100 mt2"),
                new BienRaiz(R.drawable.ic_m_dpto, "Dpto 120 mt2"),
               // new BienRaiz(R.drawable.ic_loscisnes, "Edificio Los Cisnes")
        };

        //Seteamos nuestro adapter con los diferentes tipos de deptos
        BienRaizAdapter adapter = new BienRaizAdapter(this, R.layout.listview_item_row, bienRaiz_datosinfodpto);
        listViewInfoDepto = (ListView) findViewById(R.id.listViewInfoDpto);

        listViewInfoDepto.setAdapter(adapter);

        //Metodo que envia el tipo de depto al activity form
        listViewInfoDepto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(getApplicationContext(), "click en" + view, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        Intent newActivity1 = new Intent(getApplicationContext(), FormDeptoActivity.class);
                        newActivity1.putExtra("tipoDpto", "0");
                        startActivity(newActivity1);
                        break;
                    case 1:
                        Intent newActivity2 = new Intent(getApplicationContext(), FormDeptoActivity.class);
                        newActivity2.putExtra("tipoDpto", "1");
                        startActivity(newActivity2);
                        break;
                }
            }
        });
    }
}