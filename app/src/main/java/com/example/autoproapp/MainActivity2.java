package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list.addAll(getListItem());         // Mengisi item pada list
        showRecycleGrid();                  // Menampilkan List Barangnya
    }

    private void showRecycleGrid() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        GridItemAdapter gridItemAdapter = new GridItemAdapter(list);
        recyclerView.setAdapter(gridItemAdapter);

    }

    public ArrayList<Item> getListItem() {
        String[] dataName = getResources().getStringArray(R.array.product_name);
        String[] dataDescription = getResources().getStringArray(R.array.product_description);
        String[] dataPhoto = getResources().getStringArray(R.array.product_photo);
        ArrayList<Item> listItem = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Item item = new Item();
            item.setName(dataName[i]);
            item.setDescription(dataDescription[i]);
            item.setPhoto(dataPhoto[i]);
            listItem.add(item);
        }
        return listItem;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        if (searchManager != null) {
            SearchView searchView = (SearchView) (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(MainActivity2.this, query, Toast.LENGTH_SHORT).show();
                    return true;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
