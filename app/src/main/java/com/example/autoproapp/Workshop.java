package com.example.autoproapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Workshop implements Parcelable {

    private String workshop_name;
    private String workshop_price;

    public String getWorkshop_price() {
        return workshop_price;
    }

    public void setWorkshop_price(String workshop_price) {
        this.workshop_price = workshop_price;
    }

    Workshop(){ }

    public String getWorkshop_name() {
        return workshop_name;
    }

    public void setWorkshop_name(String workshop_name) {
        this.workshop_name = workshop_name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.workshop_name);
        dest.writeString(this.workshop_price);
    }

    protected Workshop(Parcel in) {
        this.workshop_name = in.readString();
        this.workshop_price = in.readString();
    }

    public static final Creator<Workshop> CREATOR = new Creator<Workshop>() {
        @Override
        public Workshop createFromParcel(Parcel source) {
            return new Workshop(source);
        }

        @Override
        public Workshop[] newArray(int size) {
            return new Workshop[size];
        }
    };
}
