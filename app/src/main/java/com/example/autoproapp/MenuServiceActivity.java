package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuServiceActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout consultation_service_button, tune_up_button;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_service);

        address = getIntent().getStringExtra("address");

        consultation_service_button = findViewById(R.id.consultation_service_button);
        consultation_service_button.setOnClickListener(this);

        tune_up_button = findViewById(R.id.tune_up_button);
        tune_up_button.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.consultation_service_button:
                intent = new Intent(this, ConsultationServiceActivity.class);
                intent.putExtra("address", address);
                startActivity(intent);
                break;
            case R.id.tune_up_button:
                intent = new Intent(this, TuneUpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
