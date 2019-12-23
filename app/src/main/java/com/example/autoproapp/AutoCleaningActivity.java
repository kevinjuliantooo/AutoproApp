package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AutoCleaningActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout cuci_exterior, cuci_exterior_interior, cuci_wax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_cleaning);

        cuci_exterior = findViewById(R.id.cuci_exterior_button);
        cuci_exterior_interior = findViewById(R.id.cuci_exterior_interior_button);
        cuci_wax = findViewById(R.id.cuci_dan_wax_button);

        cuci_exterior.setOnClickListener(this);
        cuci_exterior_interior.setOnClickListener(this);
        cuci_wax.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.cuci_dan_wax_button:
                intent = new Intent(this, OrderTimeAndLocationActivity.class);
                startActivity(intent);
        }

    }
}
