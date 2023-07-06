package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.Model.Register.ResponseRegister;
import com.example.tugasakhir.Network.ApiService;
import com.example.tugasakhir.databinding.RegisterActivityBinding;
import com.example.tugasakhir.databinding.SuccessActivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    RegisterActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RegisterActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(RegisterActivity.this , login_activiy.class);
                startActivity(go);
            }
        });

        binding.btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.edUsername.getText().toString().trim();
                String email = binding.edEmail.getText().toString().trim();
                String password = binding.edPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    binding.edUsername.setError("Masukan username terlebih dahulu");
                } else if (TextUtils.isEmpty(email)) {
                    binding.edEmail.setError("Masukan Email terlebih dahulu");
                } else if (TextUtils.isEmpty(password)) {
                    binding.edPassword.setError("Masukan password terlebih dahulu");
                } else {
                    register(username, email, password);
                }
            }
        });
    }

            private void register(String username, String email, String password) {
                ApiService.service.requestRegistter(username, email, password).enqueue(new Callback<ResponseRegister>() {
                    @Override
                    public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                        if (response.isSuccessful()){
                            ResponseRegister responseRegister = response.body();
                            if (responseRegister.isSukses()) {
                                Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                                Intent go = new Intent(RegisterActivity.this, SuccesRegisterActivity.class);
                                startActivity(go);
                                finish();
                            }else{
                                Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRegister> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Periksa Kembali jaringan anda", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
