package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button ovo_button, creditCard_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ovo_button = findViewById(R.id.ovo_button);
        creditCard_button = findViewById(R.id.creditCard_button);

        ovo_button.setOnClickListener(this);
        creditCard_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.ovo_button:
                intent = new Intent(this, BookingCodeActivity.class);
                startActivity(intent);
            case R.id.creditCard_button:
                intent = new Intent(this, BookingCodeActivity.class);
                startActivity(intent);
        }
    }
}
