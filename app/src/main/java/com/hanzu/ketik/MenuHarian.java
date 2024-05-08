package com.hanzu.ketik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuHarian extends AppCompatActivity {

    Button input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_harian);

        input = (Button) findViewById(R.id.btn_harian);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuHarian.this, InsertActivity.class);
                startActivity(intent);
            }
        });
    }
}