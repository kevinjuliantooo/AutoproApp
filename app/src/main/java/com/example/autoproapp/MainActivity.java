package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button auto_service_button, auto_cleaning_button, auto_order_button, emergency_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        auto_service_button = findViewById(R.id.auto_service_button);
        auto_cleaning_button = findViewById(R.id.auto_cleaning_button);
        auto_order_button = findViewById(R.id.auto_order_button);
        emergency_button = findViewById(R.id.emergency_button);

        auto_service_button.setOnClickListener(this);
        auto_cleaning_button.setOnClickListener(this);
        emergency_button.setOnClickListener(this);
        auto_order_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.auto_service_button:
                intent = new Intent(this, AutoServiceActivity.class);
                startActivity(intent);
                break;
            case R.id.auto_cleaning_button:
                intent = new Intent(this, AutoCleaningActivity.class);
                startActivity(intent);
                break;
            case R.id.emergency_button:
                intent = new Intent(this, OrderTimeAndLocationActivity.class);
                intent.putExtra("additional", "emergency");
                startActivity(intent);
                break;
            case R.id.auto_order_button:
                intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.profile:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
