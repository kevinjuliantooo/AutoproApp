package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConsultationServiceActivity extends AppCompatActivity {

    private ListView workshop_listview;
    private RecyclerView recyclerView;
    private ArrayList<Workshop> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_service);

//        workshop_listview = findViewById(R.id.workshop_listview);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list.addAll(getWorkshopList());
        showRecycleList();

    }

    private void showRecycleList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListItemAdapter listItemAdapter = new ListItemAdapter(list);
        recyclerView.setAdapter(listItemAdapter);

//        ListItemAdapter.setOnItemClickCallback(new ListItemAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(Workshop data) {
//                ShowSelectedWorkshop(data);
//            }
//        });

        listItemAdapter.setOnItemClickCallback(new ListItemAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Workshop data) {
                showSelectedWorkshop(data);
            }

            private void showSelectedWorkshop(Workshop workshop) {
                Toast.makeText(getApplicationContext(), "Kamu memilih " + workshop.getWorkshop_name(), Toast.LENGTH_SHORT).show();

            }

        });

    }


//    private void ShowSelectedWorkshop(Workshop workshop) {
//        Toast.makeText(this, "Kamu memilih " + workshop.getWorkshop_name(), Toast.LENGTH_SHORT).show();
//
//    }

    public ArrayList<Workshop> getWorkshopList(){
        String[] dataWorkshopName = getResources().getStringArray(R.array.workshop_name);

//        ArrayList<Workshop> listWorkshop = new ArrayList<>();
//        for (int i = 0; i < dataWorkshopName.length; i++){
//            Workshop workshop = new Workshop();
//            workshop.setWorkshop_name(dataWorkshopName[i]);
//            listWorkshop.add(workshop);
//            System.out.println(listWorkshop);
//        }
//        return listWorkshop;

        String[] dataName = getResources().getStringArray(R.array.workshop_name);
        ArrayList<Workshop> listItem = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Workshop item = new Workshop();
            item.setWorkshop_name(dataName[i]);
            listItem.add(item);
        }
        return listItem;
    }
}
