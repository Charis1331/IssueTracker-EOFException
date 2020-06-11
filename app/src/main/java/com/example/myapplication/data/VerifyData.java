package com.example.myapplication.data;

import android.os.Parcel;
import android.os.Parcelable;

public class VerifyData implements Parcelable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VerifyData(int id) {
        this.id = id;
    }

    protected VerifyData(Parcel in) {
        id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VerifyData> CREATOR = new Creator<VerifyData>() {
        @Override
        public VerifyData createFromParcel(Parcel in) {
            return new VerifyData(in);
        }

        @Override
        public VerifyData[] newArray(int size) {
            return new VerifyData[size];
        }
    };
}
