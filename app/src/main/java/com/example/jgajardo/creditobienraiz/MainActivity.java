package com.example.jgajardo.creditobienraiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//Activity Principal
public class MainActivity extends AppCompatActivity {

    //Inicializamos nuestro listview
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos nuestro list view con casa o depto
        BienRaiz bienRaiz_datos[] = new BienRaiz[]{
                new BienRaiz(R.drawable.ic_home, "Casa"),
                new BienRaiz(R.drawable.ic_apartment, "Departamento")
        };

        //Setamos nuestro adapter con casa o depto
        BienRaizAdapter adapter = new BienRaizAdapter(this, R.layout.listview_item_row, bienRaiz_datos);

        listView = (ListView) findViewById(R.id.listview);

        //Aca colocamos nuestro header
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row, null);

        listView.addHeaderView(header);
        listView.setAdapter(adapter);
        //Metodo que envia a casa o depto segun eleccion
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
                public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
                    switch( position )
                    {
                        case 1:  Intent newActivity1 = new Intent(getApplicationContext(), CasaActivity.class);
                            startActivity(newActivity1);
                            break;
                        case 2:  Intent newActivity2 = new Intent(getApplicationContext(), DepartamentoActivity.class);
                            startActivity(newActivity2);
                            break;
                    }
            }
        });


    }


}

