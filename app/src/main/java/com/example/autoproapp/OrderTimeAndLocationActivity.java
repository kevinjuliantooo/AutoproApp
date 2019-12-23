package com.example.autoproapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderTimeAndLocationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button termandcondition_button, next_button;
    private String additional;
    private ListView destination_lv;
    private ImageView destination_image;
    private TextView destination_textView, locationDescription_textView, time_textview, date_textview;
    private Calendar currentTime;
    private String getDate, getDay, getMonth, getYear, getTime;
    private String day, month;
    private TextView destination_location_textview;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_time_and_location);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        termandcondition_button = findViewById(R.id.termAndCondition_button);
        next_button = findViewById(R.id.next_button);

        destination_image = findViewById(R.id.destination_image);
        destination_textView = findViewById(R.id.location_textView);

        destination_location_textview = findViewById(R.id.destination_location_textView);
        System.out.println("Address: " + sharedPreferences.getString("address", "Null"));
        destination_location_textview.setText(sharedPreferences.getString("address", "Null"));

        time_textview = findViewById(R.id.time_textview);
        date_textview = findViewById(R.id.date_textview);

        currentTime = Calendar.getInstance();


        getTime = new SimpleDateFormat("HH:mm").format(currentTime.getTime());
        getDay = convertDays(currentTime.get(Calendar.DAY_OF_WEEK));
        getDate = String.valueOf(currentTime.get(Calendar.DATE));
        getMonth = convertMonths(currentTime.get(Calendar.MONTH));
        getYear = String.valueOf(currentTime.get(Calendar.YEAR));

        time_textview.setText(getTime);
        date_textview.setText(getDay + ", " + getDate + " " + getMonth + " " + getYear);



        destination_image.setVisibility(View.GONE);
        destination_textView.setVisibility(View.GONE);
//        locationDescription_textView.setVisibility(View.GONE);


        if (getIntent().getStringExtra("additional") != null){
            additional = getIntent().getStringExtra("additional");
            switch (additional){
                case "emergency":
                    destination_image.setVisibility(View.VISIBLE);
                    destination_textView.setVisibility(View.VISIBLE);
//                    locationDescription_textView.setVisibility(View.VISIBLE);

            }

        }


        termandcondition_button.setOnClickListener(this);
        next_button.setOnClickListener(this);
    }

    private String convertMonths (int month_code) {
        switch (month_code) {
            case Calendar.JANUARY:
                month = "January";
                break;
            case Calendar.FEBRUARY:
                month = "February";
                break;
            case Calendar.MARCH:
                month = "March";
                break;
            case Calendar.APRIL:
                month = "April";
                break;
            case Calendar.MAY:
                month = "May";
                break;
            case Calendar.JUNE:
                month = "June";
                break;
            case Calendar.JULY:
                month = "July";
                break;
            case Calendar.AUGUST:
                month = "August";
                break;
            case Calendar.SEPTEMBER:
                month = "September";
                break;
            case Calendar.OCTOBER:
                month = "October";
                break;
            case Calendar.NOVEMBER:
                month = "November";
                break;
            case Calendar.DECEMBER:
                month = "December";
                break;
        }
        return month;
    }

    private String convertDays(int day_code) {
        switch (day_code) {
            case Calendar.SUNDAY:
                day = "Sunday";
                break;
            case Calendar.MONDAY:
                day = "Monday";
                break;
            case Calendar.TUESDAY:
                day = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                day = "Wednesday";
                break;
            case Calendar.THURSDAY:
                day = "Thursday";
                break;
            case Calendar.FRIDAY:
                day = "Friday";
                break;
            case Calendar.SATURDAY:
                day = "Saturday";
                break;
        }
        return day;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.termAndCondition_button:
                intent = new Intent(this, TermAndConditionActivity.class);
                startActivity(intent);
            case R.id.next_button:
                intent = new Intent(this, PaymentActivity.class);
                startActivity(intent);

        }
    }
}
