package com.project.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.project.myapplication.helper.PreferenceManager;
import com.project.myapplication.R;

public class Spalsh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spalsh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                PreferenceManager preferenceManager = new PreferenceManager(Spalsh.this);

                if (preferenceManager.contains("user_id")) {
                    startActivity(new Intent(Spalsh.this, MainActivity.class));
                } else {
                    startActivity(new Intent(Spalsh.this, Login.class));
                }
                finish();
            }
        }, 2000);
    }
}