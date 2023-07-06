package com.example.tugasakhir.Network;

import com.example.tugasakhir.Model.Getbahasa.ResponseGetbahasa;
import com.example.tugasakhir.Model.Login.ResponseLogin;
import com.example.tugasakhir.Model.Register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCofig {

    @GET("getBahasaPemrograman")
    Call<ResponseGetbahasa> getBahasa();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> requestLogin(
            @Field("email")
            String email,
            @Field("password")
            String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> requestRegistter(
            @Field("username")
            String username,
            @Field("email")
            String email,
            @Field("password")
            String password
    );

}
