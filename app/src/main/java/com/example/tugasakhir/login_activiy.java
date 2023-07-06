package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.Model.Login.ResponseLogin;
import com.example.tugasakhir.Network.ApiCofig;
import com.example.tugasakhir.Network.ApiService;
import com.example.tugasakhir.databinding.LoginActivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_activiy extends AppCompatActivity {

    LoginActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = LoginActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(login_activiy.this, RegisterActivity.class);
                startActivity(go);
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.email.getText().toString().trim();
                String password = binding.password.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    binding.email.setError("Masukan Email terlebih dahulu");
                } else if (TextUtils.isEmpty(password)){
                    binding.password.setError("Masukan password terlebih dahulu");
                } else {
                    login(email, password);
                }
            }

            private void login(String email, String password) {
                ApiService.service.requestLogin(email, password).enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        if (response.isSuccessful()){
                            ResponseLogin responseLogin = response.body();
                            if (responseLogin.isSukses()){
                                Toast.makeText(login_activiy.this, responseLogin.getPesan(),
                                        Toast.LENGTH_SHORT).show();

                                Bundle data = new Bundle();
                                data.putString("email", responseLogin.getDataLogin().getEmail());
                                data.putString("username", responseLogin.getDataLogin().getUsername());

                                Intent go = new Intent(login_activiy.this, Menu_Activity.class);
                                        go.putExtras(data);
                                        startActivity(go);
                                        finish();
                            } else {
                                Toast.makeText(login_activiy.this, responseLogin.getPesan(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(login_activiy.this, "Harap Periksa Internet Anda",
                                Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }


}
