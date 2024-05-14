package com.hanzu.ketik.model;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("username")
    private String username;

    public Result(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
