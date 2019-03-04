package com.example.spaceshuttleapihomework.dummy.Home;

import com.example.spaceshuttleapihomework.dummy.Home.shuttleresponseRepo.ShuttleResponse;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource implements DataSource {

    private DataSource.DataListener listener;
    private LaunchLibrary.LaunchLibraryService launchLibraryService;

    public RemoteDataSource(DataSource.DataListener listener) {
        this.listener = listener;

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        launchLibraryService = retrofit.create(LaunchLibrary.LaunchLibraryService.class);

    }

    @Override
    public void getLaunchfromDate(String date) {

        launchLibraryService.getLaunchList(date).enqueue(new Callback<List<ShuttleResponse>>() {
            private Call<List<ShuttleResponse>> call;
            private Throwable t;

            @Override
            public void onResponse(Call<List<ShuttleResponse>> call, Response<List<ShuttleResponse>> response) {
                if (response.isSuccessful()){
                    listener.onSuccess(response.body());
                }
            }




            @Override
            public void onFailure(Call<List<ShuttleResponse>> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}

