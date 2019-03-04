package com.example.spaceshuttleapihomework.dummy.Home;

import com.example.spaceshuttleapihomework.dummy.Home.shuttleresponseRepo.ShuttleResponse;

import java.util.List;

public interface DataSource {
    void getLaunchfromDate(String date);

    interface DataListener {
        void onSuccess(List<ShuttleResponse> launchResponse);
        void onFailure(Throwable throwable);
    }
}