package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class AutoServiceActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    Button continue_button;
    AutoCompleteTextView merk_mobil_autocomplete;
    String[] list_mobil;
    private ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_service);

        continue_button = findViewById(R.id.continue_button);
        continue_button.setOnClickListener(this);

        merk_mobil_autocomplete = findViewById(R.id.merek_mobil_autocomplete);

        list_mobil = getResources().getStringArray(R.array.list_mobil);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list_mobil);
        merk_mobil_autocomplete.setAdapter(adapter);
        merk_mobil_autocomplete.setOnTouchListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continue_button:
                Intent intent = new Intent(this, ChooseLocationActivity.class);
                startActivity(intent);

        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        merk_mobil_autocomplete.showDropDown();
        return false;
    }
}
