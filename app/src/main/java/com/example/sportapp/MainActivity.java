package com.example.sportapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Déclarez ces composants
    RecyclerView recyclerView;
    CustomAdapter adapter;
    List<Sport> sportList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialiser une liste
        sportList = new ArrayList<>();

        // Charger les valeurs dans la liste
        Sport sport1 = new Sport(R.drawable.basketball, "Basketball");
        Sport sport2 = new Sport(R.drawable.football, "Football");
        Sport sport3 = new Sport(R.drawable.ping, "Ping pong");
        Sport sport4 = new Sport(R.drawable.tennis, "Tennis");
        Sport sport5 = new Sport(R.drawable.volley, "Volley");

        sportList.add(sport1);
        sportList.add(sport2);
        sportList.add(sport3);
        sportList.add(sport4);
        sportList.add(sport5);

        // Lie le recyclerView a son composant et definir un layoutManager
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crée l'adapteur
        adapter = new CustomAdapter(sportList);

        // Lie le recyclerView a l'adapteur
        recyclerView.setAdapter(adapter);
    }
}