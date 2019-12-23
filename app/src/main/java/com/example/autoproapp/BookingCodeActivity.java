package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class BookingCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_code);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(BookingCodeActivity.this, ServiceProcessActivity.class);
                BookingCodeActivity.this.startActivity(mainIntent);
                BookingCodeActivity.this.finish();
            }
        }, 5000);
    }
}
