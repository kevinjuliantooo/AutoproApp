package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TuneUpActivity extends AppCompatActivity {

    private ListView workshop_listview;
    private RecyclerView recyclerView;

    private ArrayList<Workshop> list = new ArrayList<>();
    private String address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tune_up);

//        workshop_listview = findViewById(R.id.workshop_listview);

        address = getIntent().getStringExtra("address");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list.addAll(getWorkshopList());
        showRecycleList();

    }

    private void showRecycleList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListItemWithPriceAdapter listItemAdapter = new ListItemWithPriceAdapter(list);
        recyclerView.setAdapter(listItemAdapter);

//        ListItemAdapter.setOnItemClickCallback(new ListItemAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(Workshop data) {
//                ShowSelectedWorkshop(data);
//            }
//        });

        listItemAdapter.setOnItemClickCallback(new ListItemWithPriceAdapter.OnItemClickCallback() {
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
        String[] dataPrice = getResources().getStringArray(R.array.workshop_price);

        ArrayList<Workshop> listItem = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Workshop item = new Workshop();
            item.setWorkshop_name(dataName[i]);
            item.setWorkshop_price(dataPrice[i]);
            listItem.add(item);
        }
        return listItem;
    }
}
