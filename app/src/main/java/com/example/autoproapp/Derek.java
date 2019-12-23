package com.example.autoproapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Derek implements Parcelable {

    String derek_name;
    String derek_price;

    public String getDerek_name() {
        return derek_name;
    }

    public void setDerek_name(String derek_name) {
        this.derek_name = derek_name;
    }

    public String getDerek_price() {
        return derek_price;
    }

    public void setDerek_price(String derek_price) {
        this.derek_price = derek_price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.derek_name);
        dest.writeString(this.derek_price);
    }

    public Derek() {
    }

    protected Derek(Parcel in) {
        this.derek_name = in.readString();
        this.derek_price = in.readString();
    }

    public static final Parcelable.Creator<Derek> CREATOR = new Parcelable.Creator<Derek>() {
        @Override
        public Derek createFromParcel(Parcel source) {
            return new Derek(source);
        }

        @Override
        public Derek[] newArray(int size) {
            return new Derek[size];
        }
    };
}
