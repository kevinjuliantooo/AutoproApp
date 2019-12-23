package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DerekActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Derek> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derek);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list.addAll(getListDerek());

    }

    public ArrayList<Derek> getListDerek() {
        String[] derekName = getResources().getStringArray(R.array.derek_mobil);
        String[] derekPrice = getResources().getStringArray(R.array.workshop_price);

        ArrayList<Derek> listDerek = new ArrayList<>();
        for (int i = 0; i < derekName.length; i++) {
            Derek derek = new Derek();
            derek.setDerek_name(derekName[i]);
            derek.setDerek_price(derekPrice[i]);
            listDerek.add(derek);
        }
        return listDerek;

    }
}
