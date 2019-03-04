package com.example.spaceshuttleapihomework.dummy.Home;

import com.example.spaceshuttleapihomework.dummy.Home.shuttleresponseRepo.ShuttleResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class LaunchLibrary {
    public interface LaunchLibraryService {

        @GET(Constants.LAUNCH_ENDPOINT)
        Call<List<ShuttleResponse>> getLaunchList(@Path("date") String date);

    }
}
