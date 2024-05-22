package com.hanzu.ketik;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageKamar, imageHarian;
//    private TextView txtNama;
//    private String textSharedPreference;
//    private SharedPreference sharedPreference;
//    Activity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        intLayout = 1;//test back press

        imageKamar = (ImageView) findViewById(R.id.img_kamar);
        imageHarian = (ImageView) findViewById(R.id.img_harian);
//        textSharedPreference = sharedPreference.getValue(context);
//        txtNama = (TextView) findViewById(R.id.txt_name);
//        txtNama.setText(textSharedPreference);
//
//        sharedPreference = new SharedPreference();

        imageKamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuKamar.class);
                startActivity(intent);
                finish();
            }
        });

        imageHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuHarian.class);
                startActivity(intent);
                finish();
            }
        });

//        layout3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }
}