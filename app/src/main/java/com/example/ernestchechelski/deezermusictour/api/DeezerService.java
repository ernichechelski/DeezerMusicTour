package com.example.ernestchechelski.deezermusictour.api;

import com.example.ernestchechelski.deezermusictour.deezerModel.Album;
import com.example.ernestchechelski.deezermusictour.deezerModel.Playlist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ernest.chechelski on 23-Mar-18.
 */

public interface DeezerService {
    @GET("album/{albumId}")
    Call<Album> getAlbum(@Path("albumId") Long albumId);

    @GET("playlist/{playlistId}")
    Call<Playlist> getPlaylist(@Path("playlistId") Long playlistId);
}
