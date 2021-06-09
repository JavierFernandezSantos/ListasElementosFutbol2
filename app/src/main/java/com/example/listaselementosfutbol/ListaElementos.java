package com.example.listaselementosfutbol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaElementos extends AppCompatActivity {
    Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaelementos);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewElementos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador=new Adaptador((this));
        adaptador.setClickListener(new Adaptador.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Has clickado " + Arrays.toString(adaptador.getItem(position)) + " en la columna " + position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adaptador);

        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String[]> listaEquiposResultados = new ArrayList<>();
                String[] partido1=new String[5];
                partido1[0]="RM";
                partido1[1]="3";
                partido1[2]="-";
                partido1[3]="2";
                partido1[4]="BCN";

                String[] partido2=new String[5];
                partido2[0]="MAL";
                partido2[1]="1";
                partido2[2]="-";
                partido2[3]="0";
                partido2[4]="LEV";

                String[] partido3=new String[5];
                partido3[0]="OSA";
                partido3[1]="1";
                partido3[2]="-";
                partido3[3]="2";
                partido3[4]="ATH";


                listaEquiposResultados.add(partido1);
                listaEquiposResultados.add(partido2);
                listaEquiposResultados.add(partido3);
                Log.d("DATOS INSERTADOS",listaEquiposResultados.toString());
                adaptador.addData(listaEquiposResultados);
            }
        });
    }
}