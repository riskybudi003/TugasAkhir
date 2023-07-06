package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.databinding.SuccessActivityBinding;

public class SuccesRegisterActivity extends AppCompatActivity {

    SuccessActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SuccessActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(SuccesRegisterActivity.this, login_activiy.class);
                startActivity(go);
                finish();
            }
        });

        }
}
