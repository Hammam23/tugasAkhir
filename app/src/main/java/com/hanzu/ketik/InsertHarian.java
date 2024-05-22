package com.hanzu.ketik;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.hanzu.ketik.retrofit.RetrofitInstance;
import com.hanzu.ketik.service.GetResultDataService;
import com.hanzu.ketik.service.InsertResponse;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertHarian extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton, save;

    EditText harian1, harian2, harian3, harian4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_harian);

        initDatePicker();
        dateButton = findViewById(R.id.DatePickerButton);
        dateButton.setText(getTodaysdate());
        save = findViewById(R.id.btn_save_harian);
        harian1 = findViewById(R.id.harian1);
        harian2 = findViewById(R.id.harian2);
        harian3 = findViewById(R.id.harian3);
        harian4 = findViewById(R.id.harian4);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(InsertHarian.this, MenuHarian.class);
                startActivity(intent);

                String krit1 = harian1.getText().toString();
                String krit2 = harian2.getText().toString();
                String krit3 = harian3.getText().toString();
                String krit4 = harian4.getText().toString();

                GetResultDataService service = RetrofitInstance.getRetrofit()
                        .create(GetResultDataService.class);
                Call<InsertResponse> call = service.input(krit1,krit2,krit3,krit4);

                call.enqueue(new Callback<InsertResponse>() {
                    @Override
                    public void onResponse(Call<InsertResponse> call, Response<InsertResponse> response) {
                        String message = response.body().getMessage();
                        Toast.makeText(InsertHarian.this, ""+message, Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(InsertHarian.this,MenuKamar.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<InsertResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
    private String getTodaysdate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year,
                month, day);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AGU";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OKT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DES";

        return "JAN";
    }


    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}