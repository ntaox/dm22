package com.example.dm2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Regist extends AppCompatActivity {
    private String url = "http://cinema.areas.su/auth/register";
    private Button br_Zregist;
    private Button bt_Bregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        br_Zregist = findViewById(R.id.button2);
        br_Zregist.setOnClickListener(v -> {
            Intent i = new Intent(com.example.dm2.Regist.this, com.example.dm2.MainActivity.class);
            startActivity(i);
            finish();
        });
        bt_Bregist = findViewById(R.id.button3);
        bt_Bregist.setOnClickListener(v -> {
            Intent i = new Intent(com.example.dm2.Regist.this, com.example.dm2.MainActivity.class);
            startActivity(i);
            finish();
        });
    }

}