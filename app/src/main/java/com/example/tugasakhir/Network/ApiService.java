package com.example.tugasakhir.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    static String BASE_URL = "http://himtiumt.org/backend_kelompok_belajar_android/index.php/API_tugas_akhir/";

    public static Retrofit getApiCofig (){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiCofig service = getApiCofig().create(ApiCofig.class);
}
