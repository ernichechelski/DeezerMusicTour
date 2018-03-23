package com.example.ernestchechelski.deezermusictour.deezerModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ernest.chechelski on 23-Mar-18.
 */

public class PlaylistTracks {

    @SerializedName("data")
    @Expose
    private List<PlaylistDatum> data = null;
    @SerializedName("checksum")
    @Expose
    private String checksum;

    public List<PlaylistDatum> getData() {
        return data;
    }

    public void setData(List<PlaylistDatum> data) {
        this.data = data;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

}