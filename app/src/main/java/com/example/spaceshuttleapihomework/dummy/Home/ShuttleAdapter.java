package com.example.spaceshuttleapihomework.dummy.Home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.spaceshuttleapihomework.R;
import com.example.spaceshuttleapihomework.dummy.Home.shuttleresponseRepo.ShuttleResponse;

import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class ShuttleAdapater {
    public void setData(List<ShuttleResponse> shuttleResponses) {
    }

    public static class ShuttleAdapter extends RecyclerView.Adapter<ShuttleAdapter.ViewHolder> {

        private final List<ShuttleResponse> results = new ArrayList<>();


        public void setData(List<ShuttleResponse> data){
            results.clear();
            results.addAll(data);
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_view, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

            ShuttleResponse launchResponse = results.get(position);

            launchResponse.tvName.setText((CharacterIterator) ShuttleResponse.getLaunches());





        }

        @Override
        public int getItemCount() {
            return results.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            static TextView tvName;
            static TextView tvList;


            // final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                tvName = view.findViewById(R.id.tv);

            }
        }
        public interface OnItemSelectedListener{

        }
    }

}
