package com.hanzu.ketik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanzu.ketik.adapter.ResultAdapter;
import com.hanzu.ketik.model.Result;
import com.hanzu.ketik.retrofit.RetrofitInstance;
import com.hanzu.ketik.service.GetResultDataService;
import com.hanzu.ketik.service.ResultList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuKamar extends AppCompatActivity {

    private ResultAdapter adapter;
    Button kamar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kamar);

        kamar = (Button) findViewById(R.id.btn_kamar);

        GetResultDataService service = RetrofitInstance.getRetrofit()
                .create(GetResultDataService.class);

        Call<ResultList> call = service.getResultData();

        Log.wtf("URL Called", call.request().url()+"");

        call.enqueue(new Callback<ResultList>() {
            @Override
            public void onResponse(Call<ResultList> call, Response<ResultList> response) {
                generateResultList(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ResultList> call, Throwable t) {
                Toast.makeText(MenuKamar.this, "Error..." + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        kamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuKamar.this, InsertActivity.class);
                startActivity(intent);
            }
        });
    }

    private void generateResultList(ArrayList<Result> resultList) {
        recyclerView = findViewById(R.id.rec_result_list);
        adapter = new ResultAdapter(resultList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuKamar.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}