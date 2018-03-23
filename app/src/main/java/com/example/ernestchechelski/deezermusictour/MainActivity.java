package com.example.ernestchechelski.deezermusictour;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.ernestchechelski.deezermusictour.api.DeezerService;
import com.example.ernestchechelski.deezermusictour.deezerModel.Album;
import com.example.ernestchechelski.deezermusictour.deezerModel.Playlist;
import com.example.ernestchechelski.deezermusictour.deezerModel.PlaylistDatum;
import com.example.ernestchechelski.deezermusictour.deezerModel.PlaylistTracks;
import com.example.ernestchechelski.deezermusictour.deezerModel.Track;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    static String EXTRA_SPACE_PHOTO = "XDDD";

    ImageGalleryAdapter adapter;
    Retrofit retrofit;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ImageGalleryAdapter(this, new ArrayList<Image>());
        //adapter = new ImageGalleryAdapter(this, Image.getSpacePhotos());
        recyclerView.setAdapter(adapter);



        List<Long> albums = Arrays.asList(302127l,9410100l,746059l,11898198l,9180567l,400578l,7964062l);

        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.deezer.com/")
                .build();


        for(Long i:albums){
            loadNextAlbum(i);
        }

        loadPlaylist(2661417904l);
    }

    private void loadNextAlbum(final Long albumId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                DeezerService service = retrofit.create(DeezerService.class);
                Call<Album> call = service.getAlbum(albumId);
                try {
                    final Response<Album> response = call.execute();
                    Log.d("LOG",response.toString());
                    Log.d("LOG", response.body().toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Image image = new Image(response.body().getCoverXl(),response.body().getTitle());
                            adapter.addImage(image);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void loadPlaylist(final Long playlistId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                DeezerService service = retrofit.create(DeezerService.class);
                Call<Playlist> call = service.getPlaylist(playlistId);
                try {
                    final Response<Playlist> response = call.execute();
                    Log.d("LOG",response.toString());
                    Log.d("LOG", response.body().toString());
                    List<PlaylistDatum> tracks = response.body().getTracks().getData();
                    for(PlaylistDatum t:tracks){
                        loadNextAlbum(Long.valueOf(t.getAlbum().getId()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View photoView = inflater.inflate(R.layout.item_layout, parent, false);
            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

            Image spacePhoto = mSpacePhotos.get(position);
            ImageView imageView = holder.mPhotoImageView;
            Glide.with(mContext)
                    .load(spacePhoto.getUrl())
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (mSpacePhotos.size());
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = itemView.findViewById(R.id.iv_photo);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

               /* int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    Image spacePhoto = mSpacePhotos.get(position);
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(MainActivity.EXTRA_SPACE_PHOTO, spacePhoto);
                    startActivity(intent);
                }*/
            }
        }

        private List<Image> mSpacePhotos;
        private Context mContext;

        public ImageGalleryAdapter(Context context, List<Image> spacePhotos) {
            mContext = context;
            mSpacePhotos = spacePhotos;
        }

        public void addImage(Image image){
            this.mSpacePhotos.add(image);
            this.notifyItemInserted(this.mSpacePhotos.size());
        }
    }


}
