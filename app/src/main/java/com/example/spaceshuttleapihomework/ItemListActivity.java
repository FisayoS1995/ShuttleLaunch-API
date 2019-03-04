package com.example.spaceshuttleapihomework;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spaceshuttleapihomework.dummy.Home.HomeContract;
import com.example.spaceshuttleapihomework.dummy.Home.HomePresenter;
import com.example.spaceshuttleapihomework.dummy.Home.ShuttleAdapater;
import com.example.spaceshuttleapihomework.dummy.Home.shuttleresponseRepo.ShuttleResponse;

import java.util.Calendar;
import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class MainActivity extends AppCompatActivity implements HomeContract.View {

    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private TextView displayDate;

    private final ShuttleAdapater launchesAdapter = new ShuttleAdapater();

    private final HomeContract.Presenter presenter = new HomePresenter(this);
    private List<ShuttleResponse> shuttleResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDate = findViewById(R.id.tvName);

        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(MainActivity.this, android.R.style.Theme_Black_NoTitleBar,
                                onDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("MainActivity", "onDateSet: " + year + "-" + month + "-" + dayOfMonth);
                month = month +1;

                String date = month + "-" + dayOfMonth + "-" + year;
                displayDate.setText(date);
                presenter.loadListLaunches(date);
            }
        };
    }

    @Override
    public void showLaunches(List<ShuttleResponse> shuttleResponses) {
        this.shuttleResponses = shuttleResponses;
        launchesAdapter.setData(shuttleResponses);
    }



    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
