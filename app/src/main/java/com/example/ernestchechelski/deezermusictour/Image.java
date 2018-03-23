package com.example.ernestchechelski.deezermusictour;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ernest.chechelski on 23-Mar-18.
 */

public class Image implements Parcelable {

    private String mUrl;
    private String mTitle;

    public Image(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected Image(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static List<Image> getSpacePhotos() {

        return new ArrayList<>(Arrays.asList(new Image("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                new Image("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                new Image("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                new Image("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                new Image("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                new Image("http://i.imgur.com/3wQcZeY.jpg", "Satellite")));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}