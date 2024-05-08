package com.hanzu.ketik.service;

import com.google.gson.annotations.SerializedName;
import com.hanzu.ketik.model.Result;

import java.util.ArrayList;

public class ResultList {

    @SerializedName("result")
    private ArrayList<Result> results;

    public ResultList(ArrayList<Result> results){
        this.results = results;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}
