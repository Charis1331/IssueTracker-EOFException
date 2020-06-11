package com.example.myapplication.data;

import android.os.Parcel;
import android.os.Parcelable;

public class SecondCaseDataWrapper<Data extends Parcelable, Response extends Parcelable>
        implements Parcelable {

    private Data data;

    private Response response;

    public SecondCaseDataWrapper() {
    }

    public SecondCaseDataWrapper(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (this.data != null) {
            dest.writeSerializable(this.data.getClass());
            dest.writeParcelable(this.data, flags);
        }

        if (this.response != null) {
            dest.writeSerializable(this.response.getClass());
            dest.writeParcelable(this.response, flags);
        }
    }

    protected SecondCaseDataWrapper(Parcel in) {
        final Class<?> classType = (Class<?>) in.readSerializable();
        if (classType != null) {
            this.data = in.readParcelable(classType.getClassLoader());
        }
        final Class<?> classType2 = (Class<?>) in.readSerializable();
        if (classType2 != null) {
            this.response = in.readParcelable(classType2.getClassLoader());
        }
    }

    public static final Creator<SecondCaseDataWrapper> CREATOR = new Creator<SecondCaseDataWrapper>() {
        @Override
        public SecondCaseDataWrapper createFromParcel(Parcel source) {
            return new SecondCaseDataWrapper(source);
        }

        @Override
        public SecondCaseDataWrapper[] newArray(int size) {
            return new SecondCaseDataWrapper[size];
        }
    };
}
