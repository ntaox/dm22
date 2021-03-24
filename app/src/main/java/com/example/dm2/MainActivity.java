package com.example.dm2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText email, password;
    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.editTextTextEmailAddress);//Поле ввода логина
        password = findViewById(R.id.editTextTextPassword);//Поле ввода пароля
        btnLogin = findViewById(R.id.button);//Кнопка "вход"
        btnSignUp = findViewById(R.id.bt_regist);//Кнопка "Зарегистрироваться"

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Переход на окно регистрации
                Intent intent;
                intent = new Intent(com.example.dm2.MainActivity.this, Regist.class);//Переход на окно регистрации
                startActivity(intent);
            }
        });

        //Проверка пустые ли поля входа
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(com.example.dm2.MainActivity.this, "Username / Password Required", Toast.LENGTH_LONG).show(); //да пустые
                } else {
                    login();
                }
            }
        });


    }
    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        Call<com.example.dm2.LoginResponse> loginResponseCall = APIclient.getUserService().userLogin(loginRequest);//Сформировать запрос
        loginResponseCall.enqueue(new Callback<com.example.dm2.LoginResponse>() {//Вызвать запрос
            @Override
            //проверка данных

            public void onResponse(Call<com.example.dm2.LoginResponse> call, Response<com.example.dm2.LoginResponse> response) {
                if(response.isSuccessful()){        //Данные верны
                    Toast.makeText(com.example.dm2.MainActivity.this, "Добро пожаловать", Toast.LENGTH_LONG).show();//Сообщение о входе в приложение
                    Intent intent;
                    intent = new Intent(com.example.dm2.MainActivity.this, Movie_content.class);//Переход на следущий экран
                    startActivity(intent);
                }else {     //данные не верны
                    Toast.makeText(com.example.dm2.MainActivity.this, "Не правильный логин или пароль", Toast.LENGTH_LONG).show();//Сообщение о провальном входе в приложение
                }
            }

            @Override
            public void onFailure(Call<com.example.dm2.LoginResponse> call, Throwable t) { //Ошибка доступа к серверу
                Toast.makeText(com.example.dm2.MainActivity.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();////Сообщение об ошибке со стороны сервера или приложения

            }
        });
    }


}


