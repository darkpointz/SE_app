package com.example.seapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView text = findViewById(R.id.tvForgotPass);
        text.setPaintFlags(text.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }
}