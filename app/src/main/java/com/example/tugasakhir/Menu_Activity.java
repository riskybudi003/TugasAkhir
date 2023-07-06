package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.databinding.MenuActivityBinding;

public class Menu_Activity extends AppCompatActivity {

    MenuActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MenuActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().getExtras() != null) {
            Bundle data = getIntent().getExtras();
            binding.edName.setText(data.getString("username"));
        }
        binding.eventHimti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(Menu_Activity.this, DetailBahasaPemrograman.class);
                startActivity(go);
            }
        });
    }
}
