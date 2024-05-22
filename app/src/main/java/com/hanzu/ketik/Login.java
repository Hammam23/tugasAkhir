package com.hanzu.ketik;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static final String TAG = "Login";
    private static final int REQUEST_SIGNUP = 0;

    private Button btnLogin;
    private EditText username, password;

    SharedPreference sharedPreference;

    Activity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.txt_user);
        password = (EditText) findViewById(R.id.txt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        sharedPreference = new SharedPreference();

        String name = sharedPreference.getValue(context);

        if (name != null) {
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login(){
        Log.d(TAG,"Login");

        if (!validate()){
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog =
                new ProgressDialog(Login.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String isiUser = username.getText().toString();
        String isiPassword = password.getText().toString();

        InputMethodManager imm =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(username.getWindowToken(),0);

        sharedPreference.save(this, isiUser);
        Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginSucces();
                progressDialog.dismiss();
            }
        },3000);
    }
    public void onLoginSucces(){
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        btnLogin.setEnabled(true);
        finish();
    }
    public void  onLoginFailed(){
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        btnLogin.setEnabled(true);
    }
    public boolean validate(){
        boolean valid = true;

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.isEmpty()){
            username.setError("username can't be null");
            valid = false;
        }else {
            username.setError(null);
        }
        if (pass.isEmpty()){
            password.setError("Password can't be null");
            valid = false;
        }else {
            password.setError(null);
        }
        return valid;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SIGNUP){
            if (requestCode == RESULT_OK){
                this.finish();
            }
        }
    }
}