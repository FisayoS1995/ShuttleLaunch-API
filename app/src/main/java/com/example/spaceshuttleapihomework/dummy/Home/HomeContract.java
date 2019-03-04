package com.example.spaceshuttleapihomework.dummy.Home;

import com.example.spaceshuttleapihomework.dummy.Home.shuttleresponseRepo.ShuttleResponse;

import java.util.List;

import javax.xml.transform.Result;

public interface HomeContract {
    interface Presenter {
        void loadListLaunches(String date);
    }

    interface View{
        void showLaunches(List<ShuttleResponse> shuttleResponses);
        void showError(String message);

    }
}


