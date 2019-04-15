package com.example.photos;

import android.os.Parcel;
import android.os.Parcelable;




public class ImageDataModel implements Parcelable {

    String name, url;

    public ImageDataModel() {

    }

    protected ImageDataModel(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<ImageDataModel> CREATOR = new Creator<ImageDataModel>() {
        @Override
        public ImageDataModel createFromParcel(Parcel in) {
            return new ImageDataModel(in);
        }

        @Override
        public ImageDataModel[] newArray(int size) {
            return new ImageDataModel[size];
        }
    };

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }
}