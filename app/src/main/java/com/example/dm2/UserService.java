package com.example.dm2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("auth/login")
    Call<com.example.dm2.LoginResponse> userLogin(@Body com.example.dm2.LoginRequest loginRequest);

}









