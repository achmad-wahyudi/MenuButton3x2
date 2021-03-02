package com.wahyuapp.myappmenubutton3x2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataMenuMain implements Parcelable {
    private String id;
    private String name;
    private String active;

    public DataMenuMain() {
    }

    public DataMenuMain(String id, String name, String active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nama) {
        this.name = nama;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.active);
    }

    protected DataMenuMain(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.active = in.readString();
    }

    public static final Creator<DataMenuMain> CREATOR = new Creator<DataMenuMain>() {
        @Override
        public DataMenuMain createFromParcel(Parcel source) {
            return new DataMenuMain(source);
        }

        @Override
        public DataMenuMain[] newArray(int size) {
            return new DataMenuMain[size];
        }
    };
}
