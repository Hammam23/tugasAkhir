package com.hanzu.ketik.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hanzu.ketik.R;
import com.hanzu.ketik.model.Result;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    ArrayList<Result> datalist;

    public ResultAdapter(ArrayList<Result> datalist){
        this.datalist = datalist;
    }
    @NonNull
    @Override
    public ResultAdapter.ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ResultViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder{

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
