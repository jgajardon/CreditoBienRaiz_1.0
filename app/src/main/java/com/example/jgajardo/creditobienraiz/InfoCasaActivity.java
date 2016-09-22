package com.example.jgajardo.creditobienraiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//Activity tipo de casa
public class InfoCasaActivity extends AppCompatActivity {

    //Declaramos nuestro listview
    ListView listViewInfoCasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_casa);

        //Creamos nuestro arreglo de tipos de casa
        BienRaiz bienRaiz_datosinfocasa[] = new BienRaiz[]{
                new BienRaiz(R.drawable.ic_s_house, "Casa Base"),
                new BienRaiz(R.drawable.ic_m_house, "Casa Media"),
                new BienRaiz(R.drawable.ic_xl_house, "Casa Grande")
        };

        //Seteamos nuestro adapter con los diferentes tipos de casa
        BienRaizAdapter adapter = new BienRaizAdapter(this, R.layout.listview_item_row, bienRaiz_datosinfocasa);
        listViewInfoCasa= (ListView) findViewById(R.id.listViewInfoCasa);
        listViewInfoCasa.setAdapter(adapter);

        //Metodo que envia un mismo activity pero con un valor distinto de tipo de casa
        listViewInfoCasa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(getApplicationContext(), "click en" + view, Toast.LENGTH_SHORT).show();
                switch( position )
                {
                    case 0:  Intent newActivity1 = new Intent(getApplicationContext(), FormActivity.class);
                        newActivity1.putExtra("tipoCasa", "0");
                        startActivity(newActivity1);
                        break;
                    case 1:  Intent newActivity2 = new Intent(getApplicationContext(), FormActivity.class);
                        newActivity2.putExtra("tipoCasa", "1");
                        startActivity(newActivity2);
                        break;
                    case 2:  Intent newActivity3 = new Intent(getApplicationContext(), FormActivity.class);
                        newActivity3.putExtra("tipoCasa", "2");
                        startActivity(newActivity3);
                        break;
                }
            }
        });
    }
}
