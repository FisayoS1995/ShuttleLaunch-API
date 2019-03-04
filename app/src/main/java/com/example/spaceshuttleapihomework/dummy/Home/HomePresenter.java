package com.example.spaceshuttleapihomework.dummy.Home;

import com.example.spaceshuttleapihomework.dummy.Home.shuttleresponseRepo.ShuttleResponse;

import java.util.List;

import javax.sql.DataSource;
import javax.xml.transform.Result;

public class HomePresenter implements HomeContract.Presenter, DataSource.DataListener {

    private final HomeContract.View view;
    private final DataSource dataSource;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        dataSource = new RemoteDataSource(this);
    }




    @Override
    public void onSuccess(List<ShuttleResponse> shuttleResponse) {
        view.showLaunches(shuttleResponse);
    }

    @Override
    public void onFailure(Throwable throwable) {
        view.showError(throwable.getMessage());
    }

    @Override
    public void loadListLaunches(String date) {
        final DataSource dataSource = new RemoteDataSource(this);
        if(date.isEmpty()){
            view.showError("Click the text view my GUY");
            return;
        }else{
            ((RemoteDataSource) dataSource).getLaunchfromDate(date);
        }
    }
}