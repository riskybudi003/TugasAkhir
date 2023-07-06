package com.example.tugasakhir;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tugasakhir.Model.Getbahasa.DataBahasaPemrogramanItem;
import com.example.tugasakhir.Model.Getbahasa.ResponseGetbahasa;
import com.example.tugasakhir.Network.ApiCofig;
import com.example.tugasakhir.Network.ApiService;
import com.example.tugasakhir.adapter.BahasaAdapter;
import com.example.tugasakhir.databinding.DetailBahasapemrogramanBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailBahasaPemrograman extends AppCompatActivity {

    BahasaAdapter adapter;

    DetailBahasapemrogramanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailBahasapemrogramanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rcView.setHasFixedSize(true);
        binding.rcView.setLayoutManager(new LinearLayoutManager(this));

        ApiService.service.getBahasa().enqueue(new Callback<ResponseGetbahasa>() {
            @Override
            public void onResponse(Call<ResponseGetbahasa> call, Response<ResponseGetbahasa> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        ResponseGetbahasa responseGetbahasa = response.body();
                        List<DataBahasaPemrogramanItem> data = responseGetbahasa.getDataBahasaPemrograman();
                        adapter = new BahasaAdapter(data);
                        binding.rcView.setAdapter(adapter);
                    } else {
                        Toast.makeText(DetailBahasaPemrograman.this , "Data Kosong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DetailBahasaPemrograman.this,"Response Gagagl", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseGetbahasa> call, Throwable t) {
                Toast.makeText(DetailBahasaPemrograman.this, "Harap Cek Internet Anda", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
