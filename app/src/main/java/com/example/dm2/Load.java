package com.example.dm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Load extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_activity);

    }
    public void onClick(View v) {
        //Переход на окно регистрации
        Intent intent;
        intent = new Intent(com.example.dm2.Load.this, MainActivity.class);//Переход на окно регистрации
        startActivity(intent);
    }
}
